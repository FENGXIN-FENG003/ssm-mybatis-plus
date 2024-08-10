package com.fengxin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fengxin.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author FENGXIN
 * @date 2024/8/10
 * @project ssm-mybatis-plus
 * @description 继承BaseMapper接口 获取相应方法 单表操作自动生成
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
