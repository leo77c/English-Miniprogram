package com.miniprogram.www;

import com.miniprogram.www.dao.CourseDao;
import com.miniprogram.www.dao.TestDao;
import com.miniprogram.www.dao.VideoDao;
import com.miniprogram.www.dao.VideoRecordDao;
import com.miniprogram.www.entity.*;
import com.miniprogram.www.service.ChapterService;
import com.miniprogram.www.service.CourseService;
import com.miniprogram.www.service.UserService;
import com.miniprogram.www.service.WebUserService;
import com.miniprogram.www.util.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;

@SpringBootTest
class MiniprogramApplicationTests {

    @Autowired
    private WebUserService webUserService;

    @Autowired
    private ChapterService chapterService;

    @Autowired
    private VideoDao videoDao;
    @Autowired
    private VideoRecordDao videoRecordDao;
    @Autowired
    private TestDao testDao;

    @Test
    void contextLoads() {

        List<Video> list = videoDao.queryVideosByCourse(2);
        for (int i=0; i < list.size(); i++) {
            System.out.println(list.get(i).getTitle());
        }
    }


    @Test
    void testDao() {
        com.miniprogram.www.entity.Test test = new com.miniprogram.www.entity.Test();

        testDao.insertTest(test);
    }

}
