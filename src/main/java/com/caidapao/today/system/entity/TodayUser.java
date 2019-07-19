package com.caidapao.today.system.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Created by caidapao on 2019-7-17
 * Time 17:40
 * address https://today.caidapao.com
 */
public class TodayUser extends User {

    private String sex;

    public TodayUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}
