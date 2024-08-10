package com.fengxin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author FENGXIN
 * @date 2024/8/10
 * @project ssm-mybatis-plus
 * @description
 **/
@SpringBootApplication
@MapperScan("com.fengxin.mapper")
public class MpApp {
    public static void main (String[] args) {
        SpringApplication.run(MpApp.class, args);
    }
}
