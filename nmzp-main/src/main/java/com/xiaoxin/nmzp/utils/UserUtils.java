package com.xiaoxin.nmzp.utils;

import com.ruoyi.common.core.domain.model.LoginUser;
import com.xiaoxin.nmzp.server.entity.domain.SysUser;
import org.springframework.beans.BeanUtils;

public class UserUtils {
    private static ThreadLocal<SysUser> threadLocal = new ThreadLocal<>();
    /**
     * 添加用户
     * @param loginUser
     */
    public static void set(LoginUser loginUser) {
        com.ruoyi.common.core.domain.entity.SysUser user = loginUser.getUser();
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(user,sysUser);
        threadLocal.set(sysUser);
    }

    /**
     * 获取用户
     * @return
     */
    public static SysUser get() {
        return threadLocal.get();
    }

}
