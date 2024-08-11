package com.fengxin.test;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengxin.mapper.UserMapper;
import com.fengxin.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
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
     * TODO:未设置的属性默认为NULL（包装类） 空数据不会更新数据
     */
    @Test
    public void update(){
        User user = new User();
        List<User> users = new ArrayList<> ();
        user.setId (2L);
        user.setEmail ("update");
        users.add (user);
        int i = userMapper.updateById (user);
        if (i > 0) {
            System.out.println ("修改成功");
        }
    }
    
    /**
     * 自定义分页查询
     */
    @Test
    public void testQueryByAge(){
        Page<User> page = new Page<> (1,2);
        userMapper.queryByAge (page,1);
        System.out.println ("当前页：" + page.getCurrent ());
        System.out.println ("当前页数据量：" + page.getSize ());
        System.out.println ("总条数：" + page.getTotal ());
        System.out.println (page.getRecords ());
    }
    
    /**
     * QueryWrapper
     */
    @Test
    public void queryByWrapper(){
        QueryWrapper<User> wrapper = new QueryWrapper<> ();
        wrapper.like ("name","a");
        wrapper.between ("age",18,23);
        wrapper.isNotNull ("email");
        System.out.println ("userMapper.selectList (wrapper) = " + userMapper.selectList (wrapper));
    }
    
    /**
     * 排序查询
     */
    @Test
    public void orderBYDesc(){
        QueryWrapper<User> wrapper = new QueryWrapper<> ();
        wrapper.orderByDesc ("age");
        System.out.println ("userMapper.selectList (wrapper) = " + userMapper.selectList (wrapper));
    }
    
    /**
     * 删除
     */
    @Test
    public void deleteByWrapper(){
        QueryWrapper<User> wrapper = new QueryWrapper<> ();
        wrapper.isNull ("name");
        System.out.println ("userMapper.delete (wrapper) = " + userMapper.delete (wrapper));
    }
    
    /**
     * AND OR<br>
     * 更新数据<br>
     * 准备实体类，null值不会更新<br>
     */
    @Test
    public void updateByWrapper(){
        QueryWrapper<User> wrapper = new QueryWrapper<> ();
        // 链式调用
        wrapper.like ("name","a").gt ("age",18).or ().isNotNull ("email");
        User user = new User ();
        user.setEmail ("useruu@qq.com");
        user.setAge (19);
        if (userMapper.update (user,wrapper) > 0) {
            System.out.println ("更新成功！");
        }
    }
    
    /**
     * 查询列 通常用Map接收 因为查询的其他列为空
     */
    @Test
    public void selectCol(){
        QueryWrapper<User> wrapper = new QueryWrapper<> ();
        wrapper.like ("name","a");
        wrapper.select ("name");
        System.out.println ("userMapper.selectMaps (wrapper) = " + userMapper.selectMaps (wrapper));
        // userMapper.selectList (wrapper).forEach(System.out::println);
    }
    
    /**
     * condition条件
     */
    @Test
    public void selectCondition(){
        QueryWrapper<User> wrapper = new QueryWrapper<> ();
        String name = "Jack";
        Integer age = 19;
        // 使用工具类判断
        wrapper.eq (StringUtils.isNotBlank (name),"name",name).eq (age > 18,"age",age);
        userMapper.selectList (wrapper).forEach(System.out::println);
    }
    
    /**
     * UpdateWrapper<br>
     * 自带set相关属性参数 QueryWrapper还需要创建实体类传入更新数据<br>
     * 可设置null值 QueryWrapper没有此特性<br>
     */
    @Test
    public void testUpdateWrapper(){
        UpdateWrapper<User> wrapper = new UpdateWrapper<> ();
        wrapper.eq ("name" , "Jack").set ("email" , "Jack@qq.com");
        int update = userMapper.update (wrapper);
        if (update > 0) {
            System.out.println ("更新成功！");
        }
    }
    
    /**
     * LambdaQueryWrapper使用<br>
     * 功能：避免列名写错<br>
     */
    @Test
    public void testLambdaQueryWrapper(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<> ();
        lambdaQueryWrapper.eq (User::getName,"Jack")
                .eq (User::getEmail,"Jack@qq.com");
    }
    
    /**
     * LambdaQueryWrapper使用<br>
     * 功能：避免列名写错<br>
     */
    @Test
    public void testLambdaUpdateWrapper(){
        LambdaUpdateWrapper<User> lambdaUpdateWrapper = new LambdaUpdateWrapper<> ();
        lambdaUpdateWrapper.eq (User::getName,"Jack")
                .eq (User::getEmail,"Jack@qq.com")
                .set(User::getAge,18)
                .set(User::getEmail,"Jack~~~@qq.com");
    }
    
}
