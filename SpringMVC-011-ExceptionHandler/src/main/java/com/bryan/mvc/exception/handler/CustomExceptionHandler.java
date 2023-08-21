package com.bryan.mvc.exception.handler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    // 通过@ExceptionHandler注解标记该方法要处理的异常
    @ExceptionHandler(value = {ArrayIndexOutOfBoundsException.class})
    public String testCustomExceptionHandler(Exception e, Model model) {
        model.addAttribute("exKey", e);
        return "error";
    }
}
