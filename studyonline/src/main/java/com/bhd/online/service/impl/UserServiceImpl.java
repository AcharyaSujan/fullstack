package com.bhd.online.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bhd.online.models.entity.User;
import com.bhd.online.mapper.UserMapper;
import com.bhd.online.service.UserService;
import org.springframework.stereotype.Service;

/**
 * description: UserServiceImpl
 * author: DaTao
 * email: jixu65@sina.com
 * date 2023-09-11 14:21
 * version: 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
