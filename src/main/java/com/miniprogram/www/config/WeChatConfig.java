package com.miniprogram.www.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WeChatConfig {

    @Bean
    public String appId() {
        return "wx08e14dc535b6997b";
    }

    @Bean
    public String appSerect() {
        return "8219d342b065aa7c6a55cc85c5dcb975";
    }
}
