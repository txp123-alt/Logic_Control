package com.txp.logic_control.controller;

import com.alibaba.fastjson.JSON;
import com.txp.logic_control.domain.RequestAdbDto;
import com.txp.logic_control.domain.ResponseAdbDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/logic")
public class LogicController {

    @PostMapping("/question")
    public ResponseEntity<ResponseAdbDto> question(@RequestBody RequestAdbDto requestAdbDto){
        ResponseAdbDto responseAdbDto = new ResponseAdbDto();
        responseAdbDto.setAdbCommand("adb command");
        responseAdbDto.setToMq(true);
        responseAdbDto.setThreadSleepTime(10000);
        try{
            log.info("接收到请求:{}", JSON.toJSONString(requestAdbDto));
            //判断当前请求是获取点击坐的，还是查询坐标点点击完成后的操作
            //1、获取坐标点的逻辑

            //2、查询下一步执行动作的逻辑

            Thread.sleep(5000);
            responseAdbDto.setCode(HttpStatus.OK.value());
        }catch (Exception e){
            e.printStackTrace();
            responseAdbDto.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return ResponseEntity.ok().body(responseAdbDto);
    }
}
