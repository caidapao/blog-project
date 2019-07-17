package com.caidapao.today.common.security;

import com.caidapao.today.common.service.TodayUserDetailService;
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

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String[] matchers = {"/","/login","/sign/in","/sign/up", "/blog/**","/images/captcha/**"};

        http.formLogin() //  定义当需要用户登录时候，转到的登录页面。
                    .loginPage("/login") // 设置登录页面
//                    .loginProcessingUrl("/sign/in")
                    .successForwardUrl("/index")
                    .and()
                .authorizeRequests() // 定义哪些URL需要被保护、哪些不需要被保护
                    .antMatchers(matchers).permitAll() // 设置公开页面
                    .anyRequest()  //任何请求，登录授权后可访问
                    .authenticated()
                    .and()
                .csrf()
                    .disable(); // 都需要认证
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(todayUserDetailService);
        auth.authenticationProvider(todayCustomAuthenticationProvider);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder())
                .withUser("caidapao").password(passwordEncoder().encode("666666")).roles("USER");
    }

    @Override
    public void configure(WebSecurity web) {
        //解决静态资源被拦截的问题
        web.ignoring().antMatchers("/layui/**", "/today/**");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(4);
    }
}
