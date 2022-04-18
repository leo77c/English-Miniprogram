package com.miniprogram.www.service.impl;

import com.miniprogram.www.dao.CourseDao;
import com.miniprogram.www.entity.Course;
import com.miniprogram.www.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> getAllCourses() {
        List<Course> list = courseDao.queryAllCourses();
        if (list == null) throw new RuntimeException("课程列表为空");
        return list;
    }

}
