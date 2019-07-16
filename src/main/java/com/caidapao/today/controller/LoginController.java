package com.caidapao.today.controller;

import com.caidapao.today.common.util.CaptchaUtil;
import com.wf.captcha.Captcha;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by caidapao on 2019/7/14
 * Time 11:36
 * address https://today.caidapao.com
 */
@Controller
@RequestMapping
public class LoginController {


    @GetMapping(value = "/login")
    public String login() {
        System.out.println("login");
        return "views/login";
    }

    @GetMapping("/index")
    public String index() {
        System.out.println("index");
        return "views/index";
    }

    @GetMapping("/layout")
    public String layout() {
        System.out.println("layout");
        return "views/layout";
    }

    @GetMapping("/images/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CaptchaUtil.outPng(110, 34, 4, Captcha.TYPE_ONLY_NUMBER, request, response);
    }


}
