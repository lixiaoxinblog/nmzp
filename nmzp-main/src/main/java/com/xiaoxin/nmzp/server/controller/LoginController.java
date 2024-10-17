package com.xiaoxin.nmzp.server.controller;

import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.constant.HttpStatus;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.xiaoxin.nmzp.constants.NmzpConstant;
import com.xiaoxin.nmzp.server.entity.req.LoginReq;
import com.xiaoxin.nmzp.server.entity.req.PhoneLoginReq;
import com.xiaoxin.nmzp.server.service.NmzpLoginService;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@RestController
@RequestMapping("/nmzp/login")
@Validated
public class LoginController extends BaseController {
    @Autowired
    private NmzpLoginService nmzpLoginService;

    /**
     * 生成验证码
     *
     * @return
     */
    @GetMapping("/gen/{phone}")
    public AjaxResult genCode(@PathVariable("phone")
                              @NotBlank(message = "手机号码不能为空！")
                              @Length(min = 11, max = 11, message = "手机号只能为11位")
                              @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号格式有误") String phone) {
        String code = nmzpLoginService.genCode(phone);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put(NmzpConstant.CODE, code);
        return ajaxResult;
    }

    /**
     * 根据手机登录，没有择自动注册
     *
     * @param phoneLogin
     * @return token
     */
    @RequestMapping("/phone")
    public AjaxResult loginByPhone(@RequestBody @Validated PhoneLoginReq phoneLogin) {
//        nmzpLoginService.login();
        return AjaxResult.success("");
    }

    /**
     * 登录接口
     * @return
     */
    @PostMapping
    public AjaxResult login(@RequestBody @Validated LoginReq loginReq){
        String token = nmzpLoginService.login(loginReq);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put(Constants.TOKEN,token);
        return ajaxResult;
    }
}
