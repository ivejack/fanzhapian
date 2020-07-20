package com.tst.fanzhapian.enums;

import lombok.Getter;

/**
 * 用户性别
 */
@Getter
public enum UserSexEnums {
    MAN(0,"男"),
    WOMAN(1,"女");

    private Integer code;
    private String msg;
    UserSexEnums(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }
}
