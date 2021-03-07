package com.circle.service.subject;

import com.circle.mapper.SubjectMapper;
import com.circle.pojo.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public Subject insertUser(Subject user) {
        user.setUserRegisterTime(new Date());
        subjectMapper.insert(user);
        return user;
    }

    @Override
    public void deleteUser(Integer id) {
        subjectMapper.deleteById(id);
    }

    @Override
    public void updateUser(Subject user) {
        subjectMapper.update(user);
    }

    @Override
    public List<Subject> listUser() {
        List<Subject> userList = subjectMapper.listUser();
        return userList;
    }

    @Override
    public Subject getUserById(Integer id) {
        return subjectMapper.getUserById(id);
    }

    @Override
    public Subject getUserByNameOrEmail(String str) {
        return subjectMapper.getUserByNameOrEmail(str);
    }

    @Override
    public Subject getUserByName(String name) {
        return subjectMapper.getUserByName(name);
    }

    @Override
    public Subject getUserByEmail(String email) {
        return subjectMapper.getUserByEmail(email);
    }
}
