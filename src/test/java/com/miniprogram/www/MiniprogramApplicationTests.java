package com.miniprogram.www;

import com.miniprogram.www.entity.Student;
import com.miniprogram.www.service.UserService;
import com.miniprogram.www.util.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MiniprogramApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {

    }

}
