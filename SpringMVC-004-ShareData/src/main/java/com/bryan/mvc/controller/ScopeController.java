package com.bryan.mvc.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class ScopeController {
    // 通过servletAPI向request域对象共享数据
    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request) {
        request.setAttribute("testRequestScope", "Success");
        return "success";
    }

    // 通过ModelAndView向Request域对象共享数据
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        /*
        *   ModelAndView有Model和View功能
        *
        *   1. Model主要用于向域对象共享数据
        *   2. View主要用于设置视图，实现页面跳转
        */
        ModelAndView mav = new ModelAndView();
        // 处理模型数据: 向Request域对象共享数据
        mav.addObject("testRequestScope", "Success From ModelAndView");
        // 设置视图
        mav.setViewName("success");
        return mav;
    }

    // 通过Model向Request域对象共享数据
    @RequestMapping("/testModel")
    public String testModel(Model model) {
        model.addAttribute("testRequestScope", "Success From Model");
        System.out.println(model.getClass().getName());
        return "success";
    }

    // 通过Map集合向Request域对象共享数据
    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map) {
        map.put("testRequestScope", "Success From Map");
        System.out.println(map.getClass().getName());
        return "success";
    }

    // 通过ModelMap向Request域对象共享数据
    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap map) {
        map.addAttribute("testRequestScope", "Success From ModelMap");
        System.out.println(map.getClass().getName());
        return "success";
    }

    // 向Session域对象共享数据
    @RequestMapping("/testSession")
    public String testSession(HttpSession session) {
        session.setAttribute("testSessionScope", "Success From Session");
        return "success";
    }

    // 向Application域对象共享数据
    @RequestMapping("/testApplication")
    public String testApplication(HttpSession httpSession) {
        ServletContext application = httpSession.getServletContext();
        application.setAttribute("testApplicationScope", "Success From Application");
        return "success";
    }
}
