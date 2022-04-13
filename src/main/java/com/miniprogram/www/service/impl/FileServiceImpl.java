package com.miniprogram.www.service.impl;

import com.miniprogram.www.service.FileService;
import com.miniprogram.www.util.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public String uploadAvatarPicture(int userid, MultipartFile file) {
//        File tempFile = FileUtils.uploadPicture(file);
//        String fileNmae = "avatar_user-" + userid;
//        String fileUrl = FileUtils.renameFile(tempFile, fileNmae);
        return "";
    }
}
