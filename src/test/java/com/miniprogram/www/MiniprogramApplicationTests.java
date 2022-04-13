package com.miniprogram.www;

import com.miniprogram.www.util.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MiniprogramApplicationTests {

    @Test
    void contextLoads() {
        FileUtils.getQiniuUptoken();
    }

}
