package com.example.fbj.blog.controller;


import com.example.fbj.blog.dao.UserMapper;
import com.example.fbj.blog.entity.User;
import com.example.fbj.blog.utils.CommonUtils;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private UserMapper userMapper;

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

    @PostMapping(value = "/register")
    public String register(ModelMap modelMap, @RequestParam(name = "username", required = true) String username,
                           @RequestParam(name = "password", required = true) String password,
                           @RequestParam(name = "email", required = true) String email){
        if (StringUtils.isNullOrEmpty(username)) {
            modelMap.put("msg", "用户名不能为空");
            return "login";
        }
        if (StringUtils.isNullOrEmpty(password)) {
            modelMap.put("msg", "密码不能为空");
            return "login";
        }
        User user = userMapper.selectByPrimaryKey(username);
        if (user != null) {
            modelMap.put("msg", "该用户已存在");
            return "login";
        }
        user = CommonUtils.encryptPassword(password);
        user.setUsername(username);
        user.setEmail(email);
        user.setRole("2");
        int result = userMapper.insert(user);
        if (result != 0) {
            modelMap.put("msg", "注册成功！");
            modelMap.put("username", username);
            return "admin/index/welcome";
        }
        return "login";
    }
}
