package com.tst.fanzhapian.enums;

import lombok.Getter;

/**
 * 审核类型状态码
 */
@Getter
public enum CheckTypeEnums {

    CONSCIOU(0,"发表"),
    REPORT(1,"举报");

    private Integer code;
    private String msg;
    CheckTypeEnums(Integer code, String msg){
        this.code=code;
        this.msg=msg;
    }
}
