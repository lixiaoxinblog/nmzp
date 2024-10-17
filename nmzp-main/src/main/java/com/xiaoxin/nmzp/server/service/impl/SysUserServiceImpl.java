package com.xiaoxin.nmzp.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoxin.nmzp.server.entity.domain.SysUser;
import com.xiaoxin.nmzp.server.mapper.SysUserMapper;
import com.xiaoxin.nmzp.server.service.SysUserService;
import org.springframework.stereotype.Service;

/**
* @author xiaoxin
* @description 针对表【sys_user(用户信息表)】的数据库操作Service实现
* @createDate 2024-10-17 14:02:46
*/
@Service("NmzpSysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService {

}




