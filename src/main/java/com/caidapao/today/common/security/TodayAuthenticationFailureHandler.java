package com.caidapao.today.common.security;

import com.caidapao.today.common.pojo.ErrorCode;
import com.caidapao.today.common.pojo.TodayConstant;
import com.caidapao.today.common.pojo.TodayResp;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录失败handle
 * Created by caidapao on 2019-7-19
 * Time 11:41
 * address https://today.caidapao.com
 */
@Component
public class TodayAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Autowired
    private ObjectMapper mapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        TodayResp todayResp;
        if (e instanceof UsernameNotFoundException) {
            todayResp = new TodayResp(ErrorCode.SYS_USER_NOT_EXIST);
        } else if (e instanceof BadCredentialsException) {
            todayResp = new TodayResp(ErrorCode.USN_OR_PWD_WRONG);
        } else {
            todayResp = new TodayResp(ErrorCode.AUTH_FAILURE);
        }
        httpServletResponse.setContentType(TodayConstant.JSON_UTF8);
        httpServletResponse.getWriter().write(mapper.writeValueAsString(todayResp));
    }
}
