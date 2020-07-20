package com.tst.fanzhapian.enums;

import lombok.Getter;

/**
 * 审核结果状态码
 */
@Getter
public enum CheckResultEnums {

    PASS(1,"审核不通过"),
    NOPASS(2,"审核通过");

    private Integer code;
    private String msg;

    CheckResultEnums(Integer code, String msg){
        this.code=code;
        this.msg=msg;
    }
}
