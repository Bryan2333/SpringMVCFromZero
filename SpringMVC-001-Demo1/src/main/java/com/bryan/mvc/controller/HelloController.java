package com.bryan.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 *   使用具体的情况控制器处理具体的请求
 *
 */
@Controller
public class HelloController {

    //  "/" --> /WEB-INF/templates/index.html
    // 请求映射注解
    @RequestMapping("/")
    public String toIndex() {
        // 返回视图名称
        return "index";
    }

    @RequestMapping("/target")
    public String toTarget() {
        return "target";
    }
}
