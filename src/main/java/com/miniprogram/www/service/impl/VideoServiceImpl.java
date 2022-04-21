package com.miniprogram.www.service.impl;

import com.miniprogram.www.dao.VideoDao;
import com.miniprogram.www.dao.VideoRecordDao;
import com.miniprogram.www.entity.VideoRecord;
import com.miniprogram.www.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoDao videoDao;
    @Autowired
    private VideoRecordDao videoRecordDao;

    @Override
    public String getVideoUrl(int videoId) {
        String url = videoDao.queryUrlById(videoId);
        if (url == null) throw new RuntimeException("查找视频url失败");
        return url;
    }

    @Override
    public boolean addVideoRecord(int studentId, int videoId) {
        Date watchTime = new Date(System.currentTimeMillis());
        int effectNum = videoRecordDao.insertVideoRecord(studentId, videoId, watchTime);
        if (effectNum > 0) {
            System.out.println("添加视频观看记录成功！");
            return true;
        }else {
            throw new RuntimeException("添加视频观看记录失败！");
        }
    }

    @Override
    public boolean findVideoRecord(int studentId, int videoId) {
        VideoRecord videoRecord = videoRecordDao.queryVideoRecord(studentId, videoId);
        if (videoRecord == null) return false;
        return true;
    }

    /**
     * @description 更新视频观看记录，若没有记录则新添记录，若有则更新观看时间
     * @param studentId
     * @param videoId
     * @return
     */
    @Override
    public boolean updateVideoRecord(int studentId, int videoId) {
        VideoRecord videoRecord = videoRecordDao.queryVideoRecord(studentId, videoId);
        Date watchTime = new Date(System.currentTimeMillis());
        if (videoRecord == null) {
            int effectNum = videoRecordDao.insertVideoRecord(studentId, videoId, watchTime);
            if (effectNum > 0) {
                System.out.println("添加视频观看记录成功！");
                return true;
            }else {
                throw new RuntimeException("添加视频观看记录失败！");
            }
        }else {
            videoRecordDao.updateWatchTime(studentId, videoId, watchTime);
        }
        return true;
    }


}
