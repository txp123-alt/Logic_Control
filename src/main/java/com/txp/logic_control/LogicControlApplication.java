package com.txp.logic_control;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.txp.logic_control.mapper")
public class LogicControlApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogicControlApplication.class, args);
    }

}
