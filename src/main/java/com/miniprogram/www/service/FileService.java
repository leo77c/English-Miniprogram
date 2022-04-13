package com.miniprogram.www.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    String uploadAvatarPicture(int userid, MultipartFile file);

}
