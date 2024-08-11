package com.fengxin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengxin.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author FENGXIN
 * @date 2024/8/10
 * @project ssm-mybatis-plus
 * @description
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 自定义方法分页
     * @param page 分页查询
     * @param age 年龄
     * @return IPage
     */
    IPage<User> queryByAge(Page<User> page, @Param ("age") Integer age);
}
