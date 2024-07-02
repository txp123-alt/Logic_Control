package com.txp.logic_control;

import com.alibaba.fastjson.JSON;
import com.txp.logic_control.domain.RequestAdbDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class LogicControlApplicationTests {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    void contextLoads() {
        //redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
        //redisTemplate.expire(key, timeout, TimeUnit.SECONDS);

        RequestAdbDto requestAdbDto = new RequestAdbDto();
        requestAdbDto.setUser("test002");
        requestAdbDto.setPassword("Tk@199400");
        requestAdbDto.setCommandCode("adb command");
        redisTemplate.opsForValue().set("test001",requestAdbDto);
        redisTemplate.expire("test001",60, TimeUnit.SECONDS);

    }

    @Test
    void getRedisKey(){
        Object test001 = redisTemplate.opsForValue().get("test001");
        System.out.println(JSON.toJSONString(test001));
    }

}
