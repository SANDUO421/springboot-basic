package com.springboot.websocket.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.websocket.domain.User;
import com.springboot.websocket.mapper.UserServiceMapper;
import com.springboot.websocket.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 三多
 * @Time 2020/4/13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserServiceMapper, User> implements IUserService {

    /**
     * 模拟查询数据库
     *
     * @param userId
     * @return
     */
    @Override
    public User findMessage(Integer userId) {
        List<User> users = this.baseMapper.selectList(null);

        return this.baseMapper.selectById(userId);
    }
}
