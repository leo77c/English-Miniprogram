package com.miniprogram.www.dao;

import com.miniprogram.www.entity.CourseRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CourseRecordDao {

    @Select("select * from course_record where student_id=#{studentId} and course_id=#{courseId}")
    CourseRecord queryCourseRecord(int studentId, int courseId);

    @Insert("insert into course_record(student_id, course_id, start_time) values (#{studentId}, #{courseId}, #{startTime})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insertCourseRecord(CourseRecord courseRecord);

    @Select("select course_id from course_record where student_id=#{studentId}")
    List<Integer> queryCourseIdlist(int studentId);
}
