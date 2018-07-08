package com.example.fbj.blog.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    public String index(){
        return "admin/index/login";
    }

    @RequestMapping(value = "/index",method = RequestMethod.POST)
    //@ResponseBody返回json等格式，不是html页面，所以不用
    public String login(@RequestParam(name = "username",required = true) String username,
                        @RequestParam(name = "password",required = true) String password,
                        Model model){
        System.out.println("用户："+username+"密码是："+password);
        model.addAttribute("username", username);
        return "admin/index/index";
    }

    @RequestMapping(value = "/welcome")
    public String menu(){
        return "admin/index/welcome";
    }
}
