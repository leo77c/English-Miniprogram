package com.miniprogram.www.dao;

import com.miniprogram.www.entity.Chapter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ChapterDao {

    @Select("select * from chapter where course_id=#{courseId} order by number")
    List<Chapter> queryChaptersByCourse(int courseId);
}
