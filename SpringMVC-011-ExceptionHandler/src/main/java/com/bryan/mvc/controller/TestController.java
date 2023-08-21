package com.bryan.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("/testExceptionHandler")
    public String testExceptionHandler() {
        System.out.println(10 / 0);
        return "success";
    }

    @RequestMapping("/testCustomExceptionHandler")
    public String testCustomExceptionHandler() {
        int[] arr = {1, 2, 3};
        System.out.println(arr[5]);
        return "success";
    }
}
