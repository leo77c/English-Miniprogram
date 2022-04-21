package com.miniprogram.www.dao;

import com.miniprogram.www.entity.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseDao {

    @Select("select * from course order by student_count desc")
    List<Course> queryAllCourses();

    @Select("select * from course where id=#{id}")
    Course queryCourseById(int id);

    List<Course> queryCourseListById(List<Integer> idList);
}
