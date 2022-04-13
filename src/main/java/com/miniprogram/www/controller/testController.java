package com.miniprogram.www.controller;

import com.miniprogram.www.dao.StudentDao;
import com.miniprogram.www.entity.Student;
import com.miniprogram.www.util.FileUtils;
import com.miniprogram.www.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
@RequestMapping("/test")
public class testController {


    @Autowired
    private String appId;
    @Autowired
    private String appSerect;

    @RequestMapping("/createToken")
    public String hello(@RequestParam(value="id", required=true) int id,
                        @RequestParam(value="openid", required=true) String openid) {
        Student student = new Student();
        student.setId(id);
        student.setOpenid(openid);
        return JWTUtils.createWxToken(student);
    }

    @RequestMapping("/testFile")
    public int he() {

        return 7;
    }



}
