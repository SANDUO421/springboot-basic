package com.springboot.websocket.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.websocket.domain.User;

/**
 * @author 三多
 * @Time 2020/4/13
 */
public interface IUserService extends IService<User> {
    /**
     * 模拟查询数据库
     * @param userId
     * @return
     */
    User findMessage(Integer userId);
}
