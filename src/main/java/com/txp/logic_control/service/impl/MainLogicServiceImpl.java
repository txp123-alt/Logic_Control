package com.txp.logic_control.service.impl;

import com.txp.logic_control.domain.ResponseAdb;
import com.txp.logic_control.service.MainLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MainLogicServiceImpl implements MainLogicService {

    @Override
    public void mainLogic(ResponseAdb responseAdb)throws Exception {
        //判断当前请求是获取点击坐的，还是查询坐标点点击完成后的操作
        //1、获取坐标点的逻辑

        //2、查询下一步执行动作的逻辑
        log.info("执行逻辑");
        Thread.sleep(5000);
        responseAdb.setThreadSleepTime(0);
    }
}
