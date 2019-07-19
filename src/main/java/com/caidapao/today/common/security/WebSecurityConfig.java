package com.caidapao.today.common.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by caidapao on 2019/7/14
 * Time 9:40
 * address https://today.caidapao.com
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private TodayCustomAuthenticationProvider todayCustomAuthenticationProvider;
    @Autowired
    private TodayUserDetailService todayUserDetailService;
    @Autowired
    private TodayAuthenticationSuccessHandler todayAuthenticationSuccessHandler;
    @Autowired
    private TodayAuthenticationFailureHandler todayAuthenticationFailureHandler;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String[] matchers = {"/", "/login", "/blog/**", "/images/captcha/**"};
        http.formLogin() //  定义当需要用户登录时候，转到的登录页面。
                .loginPage("/login") // 设置登录页面
                .loginProcessingUrl("/login/action")
                .successForwardUrl("/index")
                .successHandler(todayAuthenticationSuccessHandler)
                .failureHandler(todayAuthenticationFailureHandler)
                .and()
                .authorizeRequests() // 定义哪些URL需要被保护、哪些不需要被保护
                .antMatchers(matchers).permitAll() // 设置公开页面
                .anyRequest()  //任何请求，登录授权后可访问
                .authenticated()
                .and()
                .csrf()
                .disable(); // 暂时关闭
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(todayUserDetailService).passwordEncoder(passwordEncoder());

    }

    @Override
    public void configure(WebSecurity web) {
        //解决静态资源被拦截的问题
        web.ignoring().antMatchers("/layui/**", "/today/**");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(4) {
            @Override
            public String encode(CharSequence rawPassword) {
                return rawPassword.toString();
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return encodedPassword.equals(rawPassword.toString());
            }
        };
    }
}
