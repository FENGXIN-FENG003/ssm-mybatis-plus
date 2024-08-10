package com.fengxin.pojo;

import lombok.Data;

/**
 * @author FENGXIN
 * @date 2024/8/10
 * @project ssm-mybatis-plus
 * @description
 **/
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
