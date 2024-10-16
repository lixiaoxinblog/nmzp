package com.xiaoxin.nmzp.server.service.impl;

import com.ruoyi.common.core.redis.RedisCache;
import com.xiaoxin.nmzp.constants.NmzpConstant;
import com.xiaoxin.nmzp.server.service.NmzpLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 前台登录业务实现类
 */
@Service
public class NmzpLoginServiceImpl implements NmzpLoginService {

    @Autowired
    private RedisCache redisCache;

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
        redisCache.setCacheObject(NmzpConstant.LOGIN_CODE_KEY + phone,code,5, TimeUnit.MINUTES);
        return code;
    }
}
