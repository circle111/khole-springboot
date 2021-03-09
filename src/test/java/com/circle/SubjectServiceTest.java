package com.circle;

import com.circle.pojo.User;
import com.circle.service.subject.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SubjectServiceTest {
    @Autowired
    private UserService subjectService;

    @Test
    public void test1() {
        System.out.println(subjectService.getUserByEmail("123@email.com"));
    }

    @Test
    public void test2() {
        for (User subject : subjectService.listUser()) {
            System.out.println(subject.toString());
        }
    }

    @Test
    public void test3() {
        System.out.println(subjectService.getUserByName("admin"));
    }

    @Test
    public void test4() {}

    @Test
    public void test5() {}

    @Test
    public void test6() {}

}
