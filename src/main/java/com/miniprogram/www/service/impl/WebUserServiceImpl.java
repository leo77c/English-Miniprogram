package com.miniprogram.www.service.impl;

import com.miniprogram.www.dao.WebUserDao;
import com.miniprogram.www.entity.Course;
import com.miniprogram.www.entity.WebUser;
import com.miniprogram.www.service.WebUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WebUserServiceImpl implements WebUserService {

    @Autowired
    WebUserDao webUserDao;

    @Override
    public boolean addWebUser(WebUser webUser) {
        if (webUserDao.queryWebUserByAccount(webUser.getAccount()) != null) {
            throw new RuntimeException("用户已存在！");
        }
        int effectNum = webUserDao.insertWebUser(webUser);
        if (effectNum > 0) {
            System.out.println("添加网页用户成功！");
            return true;
        }else {
            throw new RuntimeException("添加网页用户失败！");
        }
    }

    @Override
    public WebUser getWebUserByAccount(String account) {
        WebUser webUser = webUserDao.queryWebUserByAccount(account);
        if (webUser == null) throw new RuntimeException("用户不存在！");
        return webUser;
    }

    @Override
    public WebUser webLogin(String account, String password) {
        WebUser webUser = webUserDao.queryWebUserByAccount(account);
        if (webUser == null) throw new RuntimeException("用户不存在！");
        if (! webUser.getPassword().equals(password)) throw new RuntimeException("账号或密码不正确！");
        return webUser;
    }

    @Override
    public WebUser getWebUserById(int id) {
        WebUser webUser = webUserDao.queryWebUserById(id);
        if (webUser == null) throw new RuntimeException("用户不存在！");
        return webUser;
    }

    @Override
    public List<String> getTeacherNameForCourse(List<Course> courses) {
        List<String> nameList = new ArrayList<>();
        for (int i = 0; i < courses.size(); i++) {
            int teacherId = courses.get(i).getTeacherId();
            String teacherName = getWebUserById(teacherId).getName();
            nameList.add(teacherName);
        }

        if (nameList.size() == 0) throw new RuntimeException("教师名称列表为空");
        return nameList;
    }
}
