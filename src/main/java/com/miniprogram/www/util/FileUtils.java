package com.miniprogram.www.util;

import com.qiniu.util.Auth;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUtils {

    //七牛云的配置
    private static String accessKey = "t_5pOU7bFmfYbaOGmhsprv6TRjrbivRfA4zkTb0J";
    private static String secretKey = "Crhj7qCGnQ9yQukvwoC1LhT2fm_J0zatDrQTSpnI";
    private static String bucket = "miniprogram-resources";

//    private static String PictureStoragePath = "/Users/chenruihao/Downloads/picture/";

    public static String getQiniuUptoken() {
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        System.out.println("得到七牛云的uptoken：" + upToken);
        return upToken;
    }

//    public static File uploadPicture(MultipartFile file) {
//        if (file.isEmpty()){
//            throw new RuntimeException("文件不能为空！");
//        }
//        String filename = file.getOriginalFilename(); //获取上传文件原来的名称
//        File temp = new File(PictureStoragePath);
//        if (!temp.exists()){
//            temp.mkdirs();
//        }
//
//        File localFile = new File(PictureStoragePath + filename);
//        try {
//            file.transferTo(localFile); //把上传的文件保存至本地
//            System.out.println(file.getOriginalFilename()+" 上传成功");
//        }catch (IOException e){
//            throw new RuntimeException("上传失败！");
//        }
//
//        return localFile;
//    }
//
//    public static String renameFile(File file, String newFileName) {
//        String oldFilePath = file.getPath();
//        String dirPath = oldFilePath.substring(0, oldFilePath.lastIndexOf("/") + 1);
//        String extension = oldFilePath.substring(oldFilePath.lastIndexOf("."));
//        String newFilePath = dirPath + newFileName + extension;
//
//        File newFile = new File(newFilePath);
//        if (newFile.exists()) {
//            System.out.println("file exists!");
//            newFile.delete();
//        }
//        file.renameTo(newFile);
//        return newFilePath;
//    }


}
