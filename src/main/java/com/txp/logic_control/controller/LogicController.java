package com.txp.logic_control.controller;

import com.alibaba.fastjson.JSON;
import com.txp.logic_control.domain.RequestAdb;
import com.txp.logic_control.domain.ResponseAdb;
import com.txp.logic_control.service.MainLogicService;
import com.txp.logic_control.service.UserAuthService;
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

    private final UserAuthService userAuthService;

    private final MainLogicService mainLogicService;

    public LogicController(UserAuthService userAuthService, MainLogicService mainLogicService){
        this.userAuthService = userAuthService;
        this.mainLogicService = mainLogicService;
    }

    /**
     * 逻辑主入口
     * @param requestAdb
     * @return code 200-逻辑执行成功 401-无权限
     */
    @PostMapping("/question")
    public ResponseEntity<ResponseAdb> question(@RequestBody RequestAdb requestAdb){
        ResponseAdb responseAdb = new ResponseAdb();

        try{
            log.info("接收到请求:{}", JSON.toJSONString(requestAdb));
            //校验用户有效性
            boolean userStatus = userAuthService.check(requestAdb);
            if (userStatus){
                mainLogicService.mainLogic(responseAdb);
                responseAdb.setCode(HttpStatus.OK.value());
            }else {
                responseAdb.setCode(HttpStatus.UNAUTHORIZED.value());
            }
        }catch (Exception e){
            e.printStackTrace();
            responseAdb.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return ResponseEntity.ok().body(responseAdb);
    }
}
