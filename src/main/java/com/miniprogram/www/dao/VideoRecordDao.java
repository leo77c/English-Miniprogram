package com.miniprogram.www.dao;

import com.miniprogram.www.entity.VideoRecord;
import org.apache.ibatis.annotations.*;

import java.sql.Date;

@Mapper
public interface VideoRecordDao {

    @Select("select * from video_record where student_id=#{studentId} and video_id=#{videoId}")
    VideoRecord queryVideoRecord(int studentId, int videoId);

    @Insert("insert into video_record(student_id, video_id, watch_time) values (#{studentId}, #{videoId}, #{watchTime})")
    //@Options(useGeneratedKeys=true, keyColumn="id")
    int insertVideoRecord(int studentId, int videoId, Date watchTime);

    @Update("update video_record set watch_time=#{watchTime} where student_id=#{studentId} and video_id=#{videoId}")
    int updateWatchTime(int studentId, int videoId, Date watchTime);
}
