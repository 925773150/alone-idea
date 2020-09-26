package com.gjsm.springboot_shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Date on 2020/09/26  下午 05:07
 */
@Controller
@RequestMapping("order")
public class OrderController {

    @RequestMapping("save")
//    @RequiresRoles(value = {"admin","user"})/*同时具有admin user*/
    @RequiresPermissions("user:update:02")/*对update01有权限才能访问*/
    public String save(){
        Subject subject = SecurityUtils.getSubject();
        if(subject.hasRole("admin")){
            System.out.println("订单保存");
        }else {
            System.out.println("无权访问");
        }
        return "redirect:/index.jsp";
    }
}
