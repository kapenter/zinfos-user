package com.api.dingdang.user.mapper;

import com.api.dingdang.user.module.User;
import com.baomidou.mybatisplus.mapper.AutoMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * User 表数据库控制层接口
 *
 */
@Repository
public interface UserMapper extends AutoMapper<User,Integer> {


}