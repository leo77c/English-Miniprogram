package com.miniprogram.www;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.miniprogram.www.dao"})
public class MiniprogramApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniprogramApplication.class, args);
    }

}
