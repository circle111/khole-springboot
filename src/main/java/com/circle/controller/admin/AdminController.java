package com.circle.controller.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Api(tags = "登录接口")
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

    @ApiOperation(value = "返回一个字符串")
    @ResponseBody
    @GetMapping("/admin/hello")
    public String hello() {
        return "hello world!!";
    }

    @RequestMapping("/toLogin")
    public String tologin() {
        return "login";
    }

    @ApiOperation(value = "登录接口")
    @RequestMapping("/login")
    public String login(String username, String password, boolean rememberMe, Model model) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        System.out.println(!rememberMe);
        if (rememberMe) token.setRememberMe(true);
        else token.setRememberMe(false);
        try {
            System.out.println("controller获得用户和密码>");
            subject.login(token);
            System.out.println("login success>");
        }catch (UnknownAccountException e) {
            model.addAttribute("msg", "用户名错误");
            return "login";
        }catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "密码错误");
            return "login";
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        return "index";
    }

    @RequestMapping("/logout")
    public String logout(Model model) {
        model.addAttribute("msg", "退出成功");
        SecurityUtils.getSubject().logout();
        return "login";
    }
}
