package com.springboot.websocket.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * @author 三多
 * @Time 2020/4/13
 */
@Data
@TableName("t_user")
public class User extends Model<User> {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;
    private String name;
    private String pwd;

    @TableLogic
    private Integer deleted;
}
