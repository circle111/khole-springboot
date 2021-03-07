package com.circle;

import com.circle.pojo.Subject;
import com.circle.service.subject.SubjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SubjectServiceTest {
    @Autowired
    private SubjectService subjectService;

    @Test
    public void test1() {
        System.out.println(subjectService.getUserByEmail("123@email.com"));
    }

    @Test
    public void test2() {
        for (Subject subject : subjectService.listUser()) {
            System.out.println(subject.toString());
        }
    }

    @Test
    public void test3() {}

    @Test
    public void test4() {}

    @Test
    public void test5() {}

    @Test
    public void test6() {}

}
