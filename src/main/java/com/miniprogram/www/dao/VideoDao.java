package com.miniprogram.www.dao;

import com.miniprogram.www.entity.Video;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface VideoDao {

    @Select("select * from video where course_id=#{courseId} order by chapter, create_time")
    List<Video> queryVideosByCourse(int courseId);

    @Select("select url from video where id=#{videoId}")
    String queryUrlById(int videoId);



}
