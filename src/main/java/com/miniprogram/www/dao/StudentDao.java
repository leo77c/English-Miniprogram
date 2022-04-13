package com.miniprogram.www.dao;

import com.miniprogram.www.entity.Student;
import org.apache.ibatis.annotations.*;

@Mapper
public interface StudentDao {
    @Select("select * from student where id = #{id}")
    Student queryStudentById(int id);

    @Select("select * from student where openid = #{openid}")
    Student queryStudentByOpenid(String openid);

    @Insert("insert into student(openid) values (#{openid})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insertStudent(Student student);

    int updateStudent(Student student);

    @Delete("delete from student where id = #{id}")
    int deleteStudent(Student student);

}
