package com.caidapao.today.common.security;

import com.caidapao.today.common.pojo.TodayConstant;
import com.caidapao.today.common.pojo.TodayResp;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录成功handle
 * Created by caidapao on 2019-7-19
 * Time 11:23
 * address https://today.caidapao.com
 */
@Component
public class TodayAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private ObjectMapper mapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.setContentType(TodayConstant.JSON_UTF8);
        httpServletResponse.getWriter().write(mapper.writeValueAsString(new TodayResp(true)));
    }
}
