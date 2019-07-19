package com.caidapao.today.common.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.util.StringUtils;

import java.util.ArrayList;

/**
 * 可以自定义登录是否成功。暂时没用到
 * Created by caidapao on 2019-7-17
 * Time 19:33
 * address https://today.caidapao.com
 */
@Configuration
public class TodayCustomAuthenticationProvider implements AuthenticationProvider {


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        //以下自定义方法，判断是否登录成功
        if (!StringUtils.isEmpty(name)) {
            // 下面的权限，可以通过UserDetailsService获取得到
            return new UsernamePasswordAuthenticationToken(name, password, new ArrayList<>());
        } else {
            return null;
        }
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
