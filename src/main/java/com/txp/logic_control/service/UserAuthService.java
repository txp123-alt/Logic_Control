package com.txp.logic_control.service;

import com.txp.logic_control.domain.RequestAdb;

public interface UserAuthService {
    /**
     * 校验用户有效性
     * @param requestAdb
     * @return
     */
    boolean check(RequestAdb requestAdb);
}
