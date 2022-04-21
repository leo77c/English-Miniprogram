package com.miniprogram.www.dao;

import com.miniprogram.www.entity.Test;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestDao {

    //Test类分为Assignment作业和Exam考试，type=0为作业，=1为考试
    @Select("select * from test where course_id=#{courseId} and type=0 order by chapter, start_time")
    List<Test> queryAssignmentsByCourse(int courseId);

    @Insert("insert into test(title, start_time, end_time, total_value, course_id, type, time_limit, submit_limit, chapter)" +
            "values (#{title}, #{startTime}, #{endTime}, #{totalValue}, #{courseId}, #{type}, #{timeLimit}, #{submitLimit}, #{chapter})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insertTest(Test test);

    @Select("select * from test where id=#{id}")
    Test queryTestById(int testId);

}
