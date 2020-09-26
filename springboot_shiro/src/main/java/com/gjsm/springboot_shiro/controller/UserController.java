package com.gjsm.springboot_shiro.controller;

import com.gjsm.springboot_shiro.entity.User;
import com.gjsm.springboot_shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Date on 2020/09/26  上午 09:25
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/login")
    public String login(String username,String password){
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(username,password));
            return "redirect:/index.jsp";
        } catch (UnknownAccountException e){
            e.printStackTrace();
            System.out.println("用户名错误");
            System.out.println("用户名错误");
            System.out.println("用户名错误");
            System.out.println("用户名错误");
            System.out.println("用户名错误");
            System.out.println("用户名错误");
            System.out.println("用户名错误");
            System.out.println("用户名错误");
            System.out.println("用户名错误");
            System.out.println("用户名错误");
            System.out.println("用户名错误");
            System.out.println("用户名错误");
        } catch (IncorrectCredentialsException e){
            e.printStackTrace();
            System.out.println("密码错误");
        }
        return "redirect:/login.jsp";
    }

    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login.jsp";
    }

    /*用户注册*/
    @RequestMapping("/register")
    public String register(User user){
        try {
            userService.register(user);
            return "redirect:/login.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/register.jsp";
        }
    }
}
