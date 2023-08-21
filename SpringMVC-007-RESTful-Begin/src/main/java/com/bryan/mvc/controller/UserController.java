package com.bryan.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @GetMapping("/")
    public String TestRest() {
        return "TestRest";
    }

    /*
    *   使用Restful模拟用户的增删改查
    *
    *   /user     GET       查询所有用户信息
    *   /user/id  GET       根据用户ID查询用户信息
    *   /user     POST      添加用户信息
    *   /user     PUT       更新用户信息
    *   /user/id  DELETE    删除用户信息
    */

    @GetMapping("/user")
    public String getAllUser() {
        System.out.println("查询所有用户信息");
        return "success";
    }

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable("id") Integer id) {
        System.out.println("查询ID为" + id + "的用户信息");
        return "success";
    }

    @PostMapping("/user")
    public String addUser(String username, String password) {
        System.out.println("添加用户信息: " + username + ", " + password);
        return "success";
    }

    @PutMapping("/user")
    public String updateUser(String username, String password) {
        System.out.println("修改用户信息: " + username + ", " + password);
        return "success";
    }
}
