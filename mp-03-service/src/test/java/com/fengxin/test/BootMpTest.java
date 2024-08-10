package com.fengxin.test;

import com.fengxin.pojo.User;
import com.fengxin.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

/**
 * @author FENGXIN
 * @date 2024/8/10
 * @project ssm-mybatis-plus
 * @description 基于service的CRUD
 **/
@SpringBootTest
public class BootMpTest {
    @Autowired
    private UserService userService;
    
    /**
     * 根据id查询
     */
    @Test
    public void selectById() {
        User userServiceById = userService.getById (1L);
        System.out.println (userServiceById);
    }
    
    /**
     * 批量保存数据
     */
    @Test
    public void save() {
        User user1 = new User();
        user1.setName ("test1");
        user1.setAge (18);
        user1.setEmail ("test1@qq.com");
        User user2 = new User();
        user2.setName ("test2");
        user2.setAge (18);
        user2.setEmail ("test2@qq.com");
        ArrayList<User> users = new ArrayList<> ();
        users.add (user1);
        users.add (user2);
        boolean saved = userService.saveBatch (users);
        if (saved) {
            System.out.println ("保存数据成功");
        }
    }
    
    /**
     * 更新或保存
     */
    @Test
    public void testSaveOrUpdate() {
        User user = new User();
        user.setId (1822233506828214274L);
        user.setName ("test1---");
        user.setAge (20);
        user.setEmail ("test1@qq.com");
        boolean saved = userService.saveOrUpdate (user);
        System.out.println ("saved = " + saved);
    }
    
    @Test
    public void testRemove() {
        ArrayList<Long> ids = new ArrayList<> ();
        ids.add (1822233506828214274L);
        ids.add (1822233506828214275L);
        ids.add (1822235017482317826L);
        ids.add (1822235017482317827L);
        boolean b = userService.removeBatchByIds (ids);
        System.out.println (b);
    }
}
