package com.fengxin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengxin.pojo.User;
import com.fengxin.service.UserService;
import com.fengxin.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author FENGXIN
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-08-11 17:50:52
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




