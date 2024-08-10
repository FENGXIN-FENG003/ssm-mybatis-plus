package com.fengxin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengxin.mapper.UserMapper;
import com.fengxin.pojo.User;
import com.fengxin.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author FENGXIN
 * @date 2024/8/10
 * @project ssm-mybatis-plus
 * @description 实现UserService接口，继承ServiceImpl 另一半CRUD方法在这个类里
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
}
