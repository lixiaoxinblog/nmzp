package com.xiaoxin.nmzp.server.filter;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.exception.ServiceException;
import com.xiaoxin.nmzp.utils.JwtUtil;
import com.xiaoxin.nmzp.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(1)
public class AuthFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //过滤指定请求
        if (request.getRequestURI().startsWith("/nmzp/login")){
            filterChain.doFilter(request,response);
            return;
        }
        LoginUser loginUser = jwtUtil.getLoginUser(request);
        if (ObjectUtils.isEmpty(loginUser)){
            throw new ServiceException("登录用户异常，请重新登录！");
        }
        jwtUtil.refreshToken(loginUser);
        //存入当前线程
        UserUtils.set(loginUser);
        filterChain.doFilter(request,response);
    }
}
