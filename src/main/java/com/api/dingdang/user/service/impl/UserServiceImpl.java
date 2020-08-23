package com.api.dingdang.user.service.impl;

import com.api.dingdang.user.mapper.UserMapper;
import com.api.dingdang.user.module.User;
import com.api.dingdang.user.service.IUserService;
import com.baomidou.framework.service.impl.SuperServiceImpl;
import org.springframework.stereotype.Service;

/**
 *
 * User 表数据服务层接口实现类
 *
 */
@Service
public class UserServiceImpl extends SuperServiceImpl<UserMapper, User,Integer> implements IUserService {


}