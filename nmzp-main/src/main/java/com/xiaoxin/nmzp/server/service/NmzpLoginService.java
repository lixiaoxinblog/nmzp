package com.xiaoxin.nmzp.server.service;

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
}
