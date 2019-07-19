package com.caidapao.today.common.security;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 登录相关的url
 * Created by caidapao on 2019/7/18
 * Time 22:22
 * address https://today.caidapao.com
 */
@ConfigurationProperties(prefix = "today.security")
public class TodaySecurityParams {


    // 登录 URL
    private String login;
    // 免认证静态资源路径
    private String anonResourcesUrl;
    // 记住我超时时间
    private int rememberMeTimeout;
    // 登出 URL
    private String logoutUrl;
    // 主页 URL
    private String indexUrl;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAnonResourcesUrl() {
        return anonResourcesUrl;
    }

    public void setAnonResourcesUrl(String anonResourcesUrl) {
        this.anonResourcesUrl = anonResourcesUrl;
    }

    public int getRememberMeTimeout() {
        return rememberMeTimeout;
    }

    public void setRememberMeTimeout(int rememberMeTimeout) {
        this.rememberMeTimeout = rememberMeTimeout;
    }

    public String getLogoutUrl() {
        return logoutUrl;
    }

    public void setLogoutUrl(String logoutUrl) {
        this.logoutUrl = logoutUrl;
    }

    public String getIndexUrl() {
        return indexUrl;
    }

    public void setIndexUrl(String indexUrl) {
        this.indexUrl = indexUrl;
    }
}
