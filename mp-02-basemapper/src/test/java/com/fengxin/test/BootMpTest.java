package com.fengxin.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fengxin.mapper.UserMapper;
import com.fengxin.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author FENGXIN
 * @date 2024/8/10
 * @project ssm-mybatis-plus
 * @description 基于BaseMapper的CRUD
 **/
@SpringBootTest
public class BootMpTest {
    @Autowired
    private UserMapper userMapper;
    
    /**
     * 插入数据
     */
    @Test
    public void insert() {
        User user = new User();
        user.setName ("枫");
        user.setAge (18);
        user.setEmail ("0000001@163.com");
        int insert = userMapper.insert (user);
        if (insert > 0) {
            System.out.println ("插入数据：" + user);
        }
    }
    
    /**
     * 根据ID 批量查询
     */
    @Test
    public void selectBatchId() {
        List<Long> ids = new ArrayList<> ();
        ids.add (1L);
        ids.add (2L);
        ids.add (3L);
        userMapper.selectBatchIds (ids).forEach(System.out::println);
    }
    
    /**
     * 根据列名集合查询
     */
    @Test
    public void selectByMap() {
        Map<String,Object> map = new HashMap<> ();
        map.put("age",18);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }
    
    /**
     * 根据id删除数据
     */
    @Test
    public void delete(){
        int rows = userMapper.deleteById (-1861230591);
        if (rows > 0) {
            System.out.println ("rows = " + rows);
        }
    }
    
    /**
     * 根据实体类更新<br>
     * TODO:未设置的属性默认为空（包装类） 空数据不会更新数据
     */
    @Test
    public void update(){
        User user = new User();
        List<User> users = new ArrayList<> ();
        user.setId (2);
        user.setEmail ("update");
        users.add (user);
        int i = userMapper.updateById (user);
        if (i > 0) {
            System.out.println ("修改成功");
        }
    }
    
}
