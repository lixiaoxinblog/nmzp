package com.xiaoxin.nmzp.server.controller;

import com.ruoyi.common.core.domain.AjaxResult;
import com.xiaoxin.nmzp.server.entity.domain.SysUser;
import com.xiaoxin.nmzp.utils.UserUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/nmzp/user")
public class UserController {

    @GetMapping
    public AjaxResult getLoginUser(){
        SysUser sysUser = UserUtils.get();
        return AjaxResult.success(sysUser);
    }

}
