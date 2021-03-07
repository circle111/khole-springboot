package com.circle.service.subject;

import com.circle.pojo.Subject;

import java.util.List;

public interface SubjectService {

    /**
     * 根据id查询用户信息
     *
     * @param id 用户ID
     * @return 用户
     */
    Subject getUserById(Integer id);

    /**
     * 修改用户信息
     *
     * @param user 用户
     */
    void updateUser(Subject user);

    /**
     * 删除用户
     *
     * @param id 用户ID
     */
    void deleteUser(Integer id);

    /**
     * 添加用户
     *
     * @param user 用户
     * @return 用户
     */
    Subject insertUser(Subject user);

    /**
     * 获得用户列表
     *
     * @return 用户列表
     */
    List<Subject> listUser();

    /**
     * 根据用户名和邮箱查询用户
     *
     * @param str 用户名或Email
     * @return 用户
     */
    Subject getUserByNameOrEmail(String str);

    /**
     * 根据用户名查询用户
     *
     * @param name 用户名
     * @return 用户
     */
    Subject getUserByName(String name);

    /**
     * 根据邮箱查询用户
     *
     * @param email Email
     * @return 用户
     */
    Subject getUserByEmail(String email);
}
