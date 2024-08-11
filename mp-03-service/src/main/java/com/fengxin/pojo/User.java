package com.fengxin.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author FENGXIN
 * @date 2024/8/10
 * @project ssm-mybatis-plus
 * @description
 **/
/* 表名注解，标识实体类对应的表
 * 如果表名和实体类名相同（忽略大小写）可以省略该注解
 * 全局设置前缀（实体类不再添加@TableName）：
 * mybatis-plus: # mybatis-plus的配置
    global-config:
    db-config:
      table-prefix: sys_ # 表名前缀字符串
 */
@TableName("user")
@Data
public class User {
    /*
    描述：主键注解
    type:
        1.IdType.ASSIGN_ID 雪花算法 生成不同的Long类型id
        2.IdType.AUTO 自增长id 需要表id也设置自增
    全局设置：
    mybatis-plus:
      global-config:
        db-config:
          # 配置MyBatis-Plus操作表的默认前缀
          table-prefix: t_
          # 配置MyBatis-Plus的主键策略
          id-type: auto
     */
    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private Long id;
    /*
    非主键注解
     */
    @TableField("name")
    private String name;
    private Integer age;
    private String email;
}
