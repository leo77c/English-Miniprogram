package com.miniprogram.www.controller;

import com.miniprogram.www.entity.Course;
import com.miniprogram.www.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    /**
     * @description 得到所有课程信息的列表，以参加人数降序排序
     * @return
     */
    @RequestMapping("/getAll")
    public Map<String, Object> getAllCourses() {
        Map<String, Object> response = new HashMap<String, Object>();
        List<Course> list = courseService.getAllCourses();
        response.put("courseList", list);
        return response;
    }

}
