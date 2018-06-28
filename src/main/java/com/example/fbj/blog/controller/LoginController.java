package com.example.fbj.blog.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @RequestMapping(value = "/test")
    @ResponseBody
    public String test(){
        return "ehlloworld!";
    }
}
