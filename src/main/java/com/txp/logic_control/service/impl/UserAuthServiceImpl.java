package com.txp.logic_control.service.impl;

import com.alibaba.fastjson.JSON;
import com.txp.logic_control.domain.RequestAdb;
import com.txp.logic_control.service.UserAuthService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserAuthServiceImpl implements UserAuthService {

    private final RedisTemplate<String,Object> redisTemplate;


    public UserAuthServiceImpl(RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    @Override
    public boolean check(RequestAdb requestAdb) {
        //首先查询缓存
        Object redisCacheUser = redisTemplate.opsForValue().get(requestAdb.getUser());

        if (null == redisCacheUser){
            //redis中未能获取到当前user对象，那么去查询数据库

        }else {
            System.out.println(JSON.toJSONString(redisCacheUser));
            return true;
        }

        //数据没在缓存中，那么查询数据库
        return false;
    }
}
