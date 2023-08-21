package com.bryan.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
    // 如果视图名称中没有任何前缀，则视图会被Thymeleaf视图解析器解析
    @RequestMapping("/testThymeleafView")
    public String testThymeleafView() {
        return "success";
    }

    // 当视图名称以 forward: 开头时，SpringMVC将创建转发视图
    @RequestMapping("/testForwardView")
    public String testForwardView() {
        return "forward:/testThymeleafView";
    }

    // 当视图名称以 redirect: 开头时，SpringMVC将创建重定向视图
    @RequestMapping("/testRedirectView")
    public String testRedirectView() {
        return "redirect:/testThymeleafView";
    }
}
