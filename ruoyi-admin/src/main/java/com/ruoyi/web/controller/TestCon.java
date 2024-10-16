package com.ruoyi.web.controller;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestCon {
    @Autowired
    private TestMapper testMapper;
    @GetMapping("/test")
    public AjaxResult t(){
        SysUser sysUser = testMapper.selectById(1);
        return AjaxResult.success(sysUser);
    }
}
