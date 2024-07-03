package com.txp.logic_control.domain.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 用户对象
 */
@Data
@TableName("user")
public class user {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String username;

    private String phone;

    private String password;

    private Date created_at;

    private Date updated_at;
}
