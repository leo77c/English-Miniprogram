package com.miniprogram.www.service;

import com.miniprogram.www.entity.Course;
import com.miniprogram.www.entity.CourseRecord;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();
    boolean findCourseRecord(int studentId, int courseId);
    boolean addCourseRecord(CourseRecord courseRecord);
    List<Course> getCourseForStudent(int studentId);

}
