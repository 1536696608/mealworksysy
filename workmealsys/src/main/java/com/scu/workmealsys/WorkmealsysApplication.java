package com.scu.workmealsys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.scu.workmealsys.mapper")
@EnableCaching
public class WorkmealsysApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkmealsysApplication.class, args);
    }

}
