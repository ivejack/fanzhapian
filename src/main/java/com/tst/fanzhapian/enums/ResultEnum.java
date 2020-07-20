package com.tst.fanzhapian.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    PARAMS_ERROR(1, "参数不正确"),
    USER_NOT_EXIST(2, "用户不存在"),
    LOGINNAME_PASSWORD_ERROR(3,"用户名密码错误"),
    UPDATE_PASSWORD_ERROR(4,"密码错误"),
    USERNAME_EXIST(5, "用户名已使用"),
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
