package com.circle.controller.admin;

import com.circle.service.subject.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminController {
    @Autowired
    private SubjectService subjectService;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/userList")
    public List<Map<String, Object>> userList() {
        String sql = "select * from subject";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }
    /**
     * 后台首页
     *
     * @return
     */
    @GetMapping("/admin")
    public String index(Model model) {
        return "";
    }

    /**
     * 登录页面显示
     *
     * @return
     */
    @GetMapping("/login")
    public String loginPage() {
        return "Admin/login";
    }

    /**
     * 登录验证
     *
     * @param request
     * @param response
     * @return
     */
    @PostMapping(value = "/loginVerify", produces = {"text/plain;charset=UTF-8"})
    @ResponseBody
    public String loginVerify(HttpServletRequest request, HttpServletResponse response) {
        return "";
    }

    /**
     * 退出登录
     *
     * @param session
     * @return
     */
    @GetMapping(value = "/admin/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        session.invalidate();
        return "redirect:/login";
    }
}
