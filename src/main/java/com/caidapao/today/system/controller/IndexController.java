package com.caidapao.today.system.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by caidapao on 2019/8/22
 * Time 23:27
 * address https://today.caidapao.com
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @GetMapping("/main")
    public String index(Authentication authentication, Model model) {
        model.addAttribute("user",authentication.getPrincipal());
        return "view/index";
    }

    @GetMapping("/layout")
    public String layout() {
        return "view/layout";
    }

}
