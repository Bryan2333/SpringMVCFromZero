package com.bryan.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hello")
public class RequestMappingController {

    @RequestMapping(
            value = {"/testRequestMapping", "/test"},
            method = {RequestMethod.GET, RequestMethod.POST}
    )
    public String success() {
        return "success";
    }

    @GetMapping("/testGetMapping")
    public String testGetMapping() {
        return "success";
    }

    @PostMapping("/testPostMapping")
    public String testPostMapping() {
        return "success";
    }

    @PutMapping("/testPut")
    public String testPutMapping() {
        return "success";
    }

    @RequestMapping(
            value = "/testParams",
            params = {"username=admin", "password=123456"}
    )
    public String testParams() {
        return "success";
    }

    @RequestMapping(
            value = "/testHeaders",
            headers = {"host=localhost:8081"}
    )
    public String testHeaders() {
        return "success";
    }

//    @RequestMapping("/a?a/testAnt")
//    public String testAnt() {
//        return "success";
//    }
//    @RequestMapping("/a*a/testAnt")
//    public String testAnt() {
//        return "success";
//    }

    @RequestMapping("/testPath/{id}/{username}")
    public String testPath(@PathVariable Integer id, @PathVariable String username) {
        System.out.println("id = " + id + ", username = " + username);
        return "success";
    }
}
