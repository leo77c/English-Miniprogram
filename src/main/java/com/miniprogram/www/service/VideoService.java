package com.miniprogram.www.service;

import com.miniprogram.www.entity.VideoRecord;

public interface VideoService {

    String getVideoUrl(int videoId);
    boolean addVideoRecord(int studentId, int videoId);
    boolean findVideoRecord(int studentId, int videoId);
    boolean updateVideoRecord(int studentId, int videoId);
}
