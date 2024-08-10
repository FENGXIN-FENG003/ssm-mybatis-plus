package com.fengxin;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
    
    /**
     * @return 分页插件
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor ());
        return interceptor;
    }
}
