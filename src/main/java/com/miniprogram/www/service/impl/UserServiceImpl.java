package com.miniprogram.www.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.miniprogram.www.dao.StudentDao;
import com.miniprogram.www.entity.Student;
import com.miniprogram.www.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private StudentDao studentDao;
    @Autowired
    private String appId;
    @Autowired
    private String appSerect;


    /**
     * @description 实现小程序登录功能，调用微信APU拿code换取openid，然后在数据库中查找用户返回
     * @param code
     * @return
     */
    @Override
    public Student wxLogin(String code) {
        Student student = null;

        //访问微信API，拿code换取openid和session_key
        String urlFormat = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";
        String url = String.format(urlFormat, appId, appSerect, code);
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        Map map = JSONObject.parseObject(response, Map.class);

        if (response == null) throw new RuntimeException("访问微信API失败！");
        if (map.get("errcode") != null) throw new RuntimeException("code不正确！");

        String openid = map.get("openid").toString();
        String session_key = map.get("session_key").toString();
        //在数据库中查询openid，若存在则返回已有用户，不存在则添加用户
        student = studentDao.queryStudentByOpenid(openid);
        if (student == null) {
            Student temp = new Student();
            temp.setOpenid(openid);
            addStudent(temp);
            student = temp;
            System.out.println("新添用户" + temp.getId());
        }else {
            System.out.println("用户已存在！id为" + student.getId());
        }

        return student;
    }

    /**
     * @description 添加用户信息
     * @param student
     * @return
     */
    @Override
    public boolean addStudent(Student student) {
        if (student.getOpenid() != null && !"".equals(student.getOpenid())) {
            throw new RuntimeException("openid不能为空！");
        }
        int effectNum = studentDao.insertStudent(student);
        if (effectNum > 0) {
            return true;
        }else {
            throw new RuntimeException("添加学生用户失败！");
        }

    }

    /**
     * @description 根据用户id查找学生用户
     * @param id
     * @return
     */
    @Override
    public Student getStudentById(int id) {
        Student student = studentDao.queryStudentById(id);
        if (student == null) throw new RuntimeException("用户不存在！");
        return student;
    }

    /**
     * @description 更新学生用户的信息，这里的student中缺少openid，根据id查找用户再更新其他字段
     * @param student
     * @return
     */
    @Override
    public boolean updateStudentInfo(Student student) {
        int effectNum = studentDao.updateStudent(student);
        if (effectNum > 0) {
            System.out.println("更新学生用户信息成功！");
            return true;
        }else {
            throw new RuntimeException("更新学生用户信息失败！");
        }
    }

}
