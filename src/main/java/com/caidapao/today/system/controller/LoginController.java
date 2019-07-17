package com.caidapao.today.system.controller;

import com.caidapao.today.common.exception.TodayException;
import com.caidapao.today.common.pojo.ErrorCode;
import com.caidapao.today.common.pojo.TodayConstant;
import com.caidapao.today.common.util.CaptchaUtil;
import com.wf.captcha.Captcha;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;

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
        return "views/login";
    }

    @GetMapping("/index")
    public String index() {
        return "views/index";
    }

    @GetMapping("/layout")
    public String layout() {
        return "views/layout";
    }

    @GetMapping("/images/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CaptchaUtil.outPng(110, 34, 4, Captcha.TYPE_ONLY_NUMBER, request, response);
    }

    @PostMapping("/sign/in")
    public Object login(@NotBlank String username, @NotBlank String password, @NotBlank String verifyCode, HttpServletRequest request) {
        if (!CaptchaUtil.verify(verifyCode, request)) {
            throw new TodayException(ErrorCode.WRONG_VERIFY_CODE);
        }
        return "views/index";
    }


}
