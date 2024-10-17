package com.xiaoxin.nmzp.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.ruoyi.common.constant.HttpStatus;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.exception.ServiceException;
import com.xiaoxin.nmzp.constants.NmzpConstant;
import com.xiaoxin.nmzp.server.entity.domain.SysUser;
import com.xiaoxin.nmzp.server.entity.req.LoginReq;
import com.xiaoxin.nmzp.server.entity.req.PhoneLoginReq;
import com.xiaoxin.nmzp.server.mapper.SysUserMapper;
import com.xiaoxin.nmzp.server.service.NmzpLoginService;
import com.xiaoxin.nmzp.utils.JwtUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 前台登录业务实现类
 */
@Service
public class NmzpLoginServiceImpl implements NmzpLoginService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private JwtUtil jwtUtil;
    /**
     * 根据手机号生成6位数code
     *
     * @param phone
     * @return
     */
    @Override
    public String genCode(String phone) {
        //生成一个随机6位数
        String code = String.format("%06d", new Random().nextInt(999999));
        redisCache.setCacheObject(NmzpConstant.LOGIN_CODE_KEY + phone, code, 5, TimeUnit.MINUTES);
        return code;
    }

    /**
     * 使用手机号进行登录
     *  1.校验验证码
     *  2.新手机号进行注册
     *  3.执行登录逻辑
     * @param phoneLoginReq
     * @return
     */
    @Override
    public String loginPhone(PhoneLoginReq phoneLoginReq) {
        if (checkCode(phoneLoginReq)){
            throw new ServiceException("验证码过期");
        }
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getPhonenumber, phoneLoginReq.getPhone());
        SysUser sysUser = sysUserMapper.selectOne(queryWrapper);
        String defaultPwd = "123456";
        if (ObjectUtils.isEmpty(sysUser)){
            //简单注册用户
            SysUser user = new SysUser();
            user.setUsername(phoneLoginReq.getPhone());
            user.setPhonenumber(phoneLoginReq.getPhone());
            user.setNickName("niuma:"+new Random().nextLong());
            user.setPassword(bCryptPasswordEncoder.encode(defaultPwd));
            sysUserMapper.insert(user);
            sysUser = user;
        }
        LoginUser loginUser = genLoginUser(sysUser);
        return jwtUtil.createToken(loginUser);
    }

    /**
     * 使用密码登录
     *
     * @param loginReq
     * @return
     */
    @Override
    public String login(LoginReq loginReq) {
        String token = doLogin(loginReq);
        return token;
    }

    /**
     * 执行登录逻辑
     *
     * @param loginReq
     * @return
     */
    private String doLogin(LoginReq loginReq) {
        String username = loginReq.getUsername();
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getUsername, username);
        SysUser sysUser = sysUserMapper.selectOne(queryWrapper);
        if (ObjectUtils.isEmpty(sysUser)) {
            throw new ServiceException("用户名或密码错误!", HttpStatus.UNAUTHENTICATED);
        }
        if (!bCryptPasswordEncoder.matches(loginReq.getPassword(), sysUser.getPassword())) {
            throw new ServiceException("用户名或密码错误!", HttpStatus.UNAUTHENTICATED);
        }
        //生成token 返回
        LoginUser loginUser = genLoginUser(sysUser);
        return jwtUtil.createToken(loginUser);
    }

    /**
     * 生成登陆用户信息
     * @param sysUser
     * @return
     */
    private LoginUser genLoginUser(SysUser sysUser) {
        LoginUser loginUser = new LoginUser();
        com.ruoyi.common.core.domain.entity.SysUser user = new com.ruoyi.common.core.domain.entity.SysUser();
        BeanUtils.copyProperties(sysUser,user);
        loginUser.setUser(user);
        return loginUser;
    }

    /**
     * 校验验证码
     */
    public boolean checkCode(PhoneLoginReq phoneLoginReq) {
        String code = phoneLoginReq.getCode();
        String cacheCode = redisCache.getCacheObject(NmzpConstant.LOGIN_CODE_KEY + code);
        if (ObjectUtils.isEmpty(cacheCode)){
            return false;
        }
        return phoneLoginReq.getPhone().equals(cacheCode);
    }
}
