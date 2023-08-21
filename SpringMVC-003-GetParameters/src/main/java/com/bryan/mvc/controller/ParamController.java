package com.bryan.mvc.controller;

import com.bryan.mvc.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class ParamController {
    @RequestMapping("/")
    public String toIndex() {
        return "index";
    }

    @RequestMapping("/testServletAPI")
    // 形参位置的request表示当前请求
    public String testServletAPI(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username = " + username + ", password = " + password);
        return "test_param";
    }

    //    @RequestMapping("/testParam")
//    public String testParam(String username, String password) {
//        System.out.println("username = " + username + ", password = " + password);
//        return "test_param";
//    }
    @RequestMapping("/testParam")
    public String testParam(
            @RequestParam(value = "user_name", defaultValue = "张三") String username,
            @RequestParam("password") String password,
            @RequestParam("hobby") String[] hobby) {
        System.out.println("username = " + username + ", password = " + password + ", hobbies = " + Arrays.toString(hobby));
        return "test_param";
    }

    @RequestMapping("/testHeader")
    public String testHeader(@RequestHeader("Host") String host) {
        System.out.println("Host = " + host);
        return "test_param";
    }

    @RequestMapping("/testCookie")
    public String testCookie(@CookieValue("JSESSIONID") String JSESSIONID) {
        System.out.println("JSESSIONID = " + JSESSIONID);
        return "test_param";
    }

    @RequestMapping("/testPOJO")
    public String testPOJO(User user) {
        System.out.println(user);
        return "test_param";
    }
}
