package com.caidapao.today.system.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by caidapao on 2019/10/27
 * Time 20:52
 * address https://today.caidapao.com
 */
@Slf4j
@Controller
@RequestMapping("/article")
public class ArticleController {


    @GetMapping(value = "/createArticle")
    public String createArticle() {
        return "view/article/createArticle";
    }

    @GetMapping(value = "/articleAll")
    public String articleAll() {
        return "view/article/articleAll";
    }
}
