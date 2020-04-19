package com.springboot.websocket.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.websocket.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 三多
 * @Time 2020/4/13
 */
@Mapper
public interface UserServiceMapper extends BaseMapper<User> {
}
