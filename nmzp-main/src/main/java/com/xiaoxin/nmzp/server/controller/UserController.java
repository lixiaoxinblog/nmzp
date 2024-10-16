package com.xiaoxin.nmzp.server.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/nmzp/user")
public class UserController extends BaseController {

    /**
     * 根据手机登录，没有择自动注册
     * @param phone 手机号
     * @return token
     */
    @RequestMapping("/login/{phone}")
    public AjaxResult loginByPhone(@PathVariable("phone") @NotBlank(message = "手机号不能为空！") String phone){

        return AjaxResult.success("");
    }
}
