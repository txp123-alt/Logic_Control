package com.txp.logic_control;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.txp.logic_control.domain.RequestAdb;
import com.txp.logic_control.domain.dto.user;
import com.txp.logic_control.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootTest
@Slf4j
class LogicControlApplicationTests {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        //redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
        //redisTemplate.expire(key, timeout, TimeUnit.SECONDS);

        RequestAdb requestAdb = new RequestAdb();
        requestAdb.setUser("test002");
        requestAdb.setPassword("Tk@199400");
        requestAdb.setCommandCode("adb command");
        redisTemplate.opsForValue().set("test001", requestAdb);
        redisTemplate.expire("test001",60, TimeUnit.SECONDS);

    }

    @Test
    void getRedisKey(){
        Object test001 = redisTemplate.opsForValue().get("test001");
        System.out.println(JSON.toJSONString(test001));
    }

    @Test
    void testMybatisPlus(){
        //user user = userMapper.selectById(1);
        QueryWrapper<user> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username","firestUser").eq("password","Tk@199400");
        user user = userMapper.selectOne(userQueryWrapper);
        log.info(JSON.toJSONString(user));
    }

}
