package com.tst.fanzhapian.enums;

import lombok.Getter;

/**
 * 审核状态状态码
 */
@Getter
public enum CheckStatuEnums {

    UNCHECK(0,"未审核"),
    CHECK(1,"已审核");

    private Integer code;
    private String msg;

    CheckStatuEnums(Integer code, String msg){
        this.code=code;
        this.msg=msg;
    }

}
