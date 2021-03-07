package com.circle.mapper;

import com.circle.pojo.Subject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SubjectMapper {
    /**
     * 添加
     *
     * @param subject 用户
     * @return 影响行数
     */
    int insert(Subject subject);

    /**
     * 根据ID删除
     *
     * @param userId 用户ID
     * @return 影响行数
     */
    int deleteById(Integer userId);

    /**
     * 更新
     *
     * @param subject 用户
     * @return 影响行数
     */
    int update(Subject subject);

    /**
     * 根据ID查询
     *
     * @param userId 用户ID
     * @return 用户
     */
    Subject getUserById(Integer userId);

    /**
     * 获得用户列表
     *
     * @return  用户列表
     */
    List<Subject> listUser() ;


    /**
     * 根据用户名或Email获得用户
     *
     * @param str 用户名或Email
     * @return 用户
     */
    Subject getUserByNameOrEmail(String str) ;

    /**
     * 根据用户名查用户
     *
     * @param name 用户名
     * @return 用户
     */
    Subject getUserByName(String name);

    /**
     * 根据Email查询用户
     *
     * @param email 邮箱
     * @return 用户
     */
    Subject getUserByEmail(String email) ;
}
