package com.caidapao.today.common.security;

import com.caidapao.today.system.entity.TodayUser;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by caidapao on 2019-7-17
 * Time 16:40
 * address https://today.caidapao.com
 */
@Component
public class TodayUserDetailService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        if (StringUtils.isEmpty(username)) {
            return null;
        }
        TodayUser todayUser = new TodayUser(username, "123456", authorities);
        todayUser.setSex("MALE");
        return todayUser;
    }
}
