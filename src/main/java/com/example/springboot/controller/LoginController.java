package com.example.springboot.controller;

import com.example.springboot.util.StrUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author by LMGD
 * @date 2021-07-14 14:53
 * @description
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/user/login")
    public String toIndex(@RequestParam(name = "userName") String userName, @RequestParam(name = "password") String password, Model
            model, HttpSession session) {
        System.out.println("===debug===userName=" + userName + ",password=" + password);
        String msg = null;
        if (StrUtils.isEmpty(userName)) {
            msg = "用户名不能为空";
            model.addAttribute("msg", msg);
            return "login";
        }
        if (StrUtils.isEmpty(password)) {
            msg = "密码不能为空";
            model.addAttribute("msg", msg);
            return "login";
        }
        if (!StrUtils.isEmpty(userName) && password.equals("123456")) {
            session.setAttribute("loginUser", userName);
        } else {
            msg = "密码不正确";
            model.addAttribute("msg", msg);
            return "login";
        }
        return "redirect:/index";
    }

    /**
     * 注销
     */
    @RequestMapping("/user/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/index";
    }
}
