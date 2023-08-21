package com.bryan.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class TestController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    // 测试default-servlet-handler
    @RequestMapping("/testStaticResource")
    public String testStaticResource() {
        return "static_resource";
    }

    // 测试异常处理器
    @RequestMapping("/testExceptionHandler")
    public String testExceptionHandler() {
        System.out.println(10 / 0);
        return "hello";
    }

    // 测试上传解析器
    @RequestMapping(value = "/testFileUpload", method = RequestMethod.POST)
    public String testFileUpload(@RequestParam("file") MultipartFile file) {
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getContentType());
        return "success";
    }
}
