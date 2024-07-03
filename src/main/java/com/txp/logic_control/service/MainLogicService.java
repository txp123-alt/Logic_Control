package com.txp.logic_control.service;

import com.txp.logic_control.domain.ResponseAdb;

public interface MainLogicService {

    /**
     * 计算主逻辑
     * @param responseAdb
     */
    void mainLogic(ResponseAdb responseAdb)throws Exception;
}
