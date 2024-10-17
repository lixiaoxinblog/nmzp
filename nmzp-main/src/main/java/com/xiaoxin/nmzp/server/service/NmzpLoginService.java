package com.xiaoxin.nmzp.server.service;

import com.xiaoxin.nmzp.server.entity.req.LoginReq;
import com.xiaoxin.nmzp.server.entity.req.PhoneLoginReq;

/**
 * 前台登录业务类
 */
public interface NmzpLoginService {


    /**
     * 根据手机号生成6位数code
     *
     * @param phone
     * @return
     */
    String genCode(String phone);

    /**
     * 使用密码登录
     * @param loginReq
     * @return
     */
    String login(LoginReq loginReq);

    /**
     * 使用手机号进行登录
     * @param phoneLoginReq
     * @return
     */
    String loginPhone(PhoneLoginReq phoneLoginReq);
}
