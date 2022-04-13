package com.miniprogram.www.service;


import com.miniprogram.www.entity.Student;

import java.util.Map;

public interface UserService {

    Student wxLogin(String code);
    boolean addStudent(Student student);
    Student getStudentById(int id);
    boolean updateStudentInfo(Student userInfo);
    boolean deleteStudent(Student student);
}
