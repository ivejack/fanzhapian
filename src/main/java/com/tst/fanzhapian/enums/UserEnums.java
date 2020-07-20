package com.tst.fanzhapian.enums;

import lombok.Getter;

/**
 * 用户状态
 */
@Getter
public enum UserEnums {

    DIE(0,"该用户已注销"),
    LIVING(1,"在线用户");

    private Integer code;
    private String msg;
    UserEnums(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }
}
