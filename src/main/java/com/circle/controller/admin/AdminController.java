package com.circle.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

    @RequestMapping({"/", "/index"})
    public String toIndex(Model model) {
        model.addAttribute("msg", "hello, shiro");
        return "index";
    }
    @RequestMapping("/user/add")
    public String toAdd() {
        return "user/add";
    }

    @RequestMapping("/user/update")
    public String toUpdate() {
        return "user/update";
    }

    @ResponseBody
    @GetMapping("/admin/hello")
    public String hello() {
        return "hello world!!";
    }

    @RequestMapping("/toLogin")
    public String tologin() {
        return "login";
    }
}
