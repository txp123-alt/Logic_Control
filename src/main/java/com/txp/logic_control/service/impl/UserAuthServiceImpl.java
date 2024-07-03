package com.txp.logic_control.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.txp.logic_control.domain.RequestAdb;
import com.txp.logic_control.domain.dto.user;
import com.txp.logic_control.mapper.UserMapper;
import com.txp.logic_control.service.UserAuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class UserAuthServiceImpl implements UserAuthService {

    private final RedisTemplate<String,Object> redisTemplate;

    private final UserMapper userMapper;


    public UserAuthServiceImpl(RedisTemplate redisTemplate, UserMapper userMapper){
        this.redisTemplate = redisTemplate;
        this.userMapper = userMapper;
    }

    @Override
    public boolean check(RequestAdb requestAdb) {

        user user = null;
        //首先查询缓存
        user= (user)redisTemplate.opsForValue().get(requestAdb.getUser());
        //数据没在缓存中，那么查询数据库
        if (null == user){
            log.info("查询数据库");
            //redis中未能获取到当前user对象，那么去查询数据库
            QueryWrapper<user> userQueryWrapper = new QueryWrapper<>();
            userQueryWrapper.eq("username",requestAdb.getUser());
            user = userMapper.selectOne(userQueryWrapper);
            if (null != user){
                //将user对象放到缓存
                redisTemplate.opsForValue().set(user.getUsername(),user);
                //用户名缓存60秒
                redisTemplate.expire(user.getUsername(),60, TimeUnit.SECONDS);
            }
        }

        if (null != user){
            return true;
        }
        log.info("用户查询失败");
        return false;
    }
}
