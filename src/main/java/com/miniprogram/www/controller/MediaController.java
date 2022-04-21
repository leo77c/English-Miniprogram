package com.miniprogram.www.controller;

import com.miniprogram.www.util.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MediaController {


//    /**
//     * @description 上传头像图片到服务器
//     * @param file
//     * @return
//     */
//    @RequestMapping("upload/avatarPic")
//    public Map<String, Object> uploadAvatarPicture( @RequestParam("file") MultipartFile file ) {
//        Map<String, Object> response = new HashMap<String, Object>();
//        int userid = (int) request.getAttribute("userid");
//        String fileUrl = fileService.uploadAvatarPicture(userid, file);
//        response.put("fileUrl",fileUrl);
//
//        return response;
//    }

    /**
     * @description 得到七牛云的上传token
     * @return
     */
    @RequestMapping("/upload/getuptoken")
    public Map<String, Object> getQiniuUptoken() {
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("uptoken", FileUtils.getQiniuUptoken());
        return response;
    }
}
