package com.miniprogram.www.controller;

import com.miniprogram.www.annotation.CurrentUser;
import com.miniprogram.www.dao.VideoRecordDao;
import com.miniprogram.www.entity.VideoRecord;
import com.miniprogram.www.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.zip.CRC32;

@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    /**
     * @description 得到视频的url，同时记录视频观看信息，若有则更新时间
     * @param videoId
     * @param currentUserId
     * @return
     */
    @RequestMapping("/geturl")
    public Map<String, Object> getVideoUrl(@RequestParam(value="id", required=true) int videoId,
                                           @CurrentUser Integer currentUserId) {
        Map<String, Object> response = new HashMap<>();
        videoService.updateVideoRecord(currentUserId, videoId);
        String url = videoService.getVideoUrl(videoId);
        response.put("url", url);
        response.put("success", true);

        return response;
    }
}
