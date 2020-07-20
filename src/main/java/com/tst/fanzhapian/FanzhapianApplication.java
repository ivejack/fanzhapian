package com.tst.fanzhapian;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.tst.fanzhapian.mapper")
public class FanzhapianApplication {

    public static void main(String[] args) {
        SpringApplication.run(FanzhapianApplication.class, args);
    }

}
