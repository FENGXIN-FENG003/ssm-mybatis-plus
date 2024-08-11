package com.fengxin.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.fengxin.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author FENGXIN
* @description 针对表【user】的数据库操作Mapper
* @createDate 2024-08-11 17:50:52
* @Entity com.fengxin.pojo.User
*/
public interface UserMapper extends BaseMapper<User> {
    List<User> selectByIdAndAgeOrderById (@Param("id") Long id , @Param("age") Integer age);
}




