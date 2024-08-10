package com.fengxin.test;

import com.fengxin.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author FENGXIN
 * @date 2024/8/10
 * @project ssm-mybatis-plus
 * @description
 **/
@SpringBootTest
public class BootMpTest {
    @Autowired
    private UserMapper userMapper;
    
    @Test
    public void queryAll() {
        userMapper.selectList (null).forEach(System.out::println);
    }
}
