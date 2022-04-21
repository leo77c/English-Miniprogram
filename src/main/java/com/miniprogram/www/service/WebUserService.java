package com.miniprogram.www.service;

import com.miniprogram.www.entity.Course;
import com.miniprogram.www.entity.WebUser;

import java.util.List;

public interface WebUserService {

    boolean addWebUser(WebUser webUser);
    WebUser getWebUserByAccount(String account);
    WebUser webLogin(String account, String password);
    WebUser getWebUserById(int id);
    List<String> getTeacherNameForCourse(List<Course> courses);
}
