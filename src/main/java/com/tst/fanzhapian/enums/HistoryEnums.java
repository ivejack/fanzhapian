package com.tst.fanzhapian.enums;

import lombok.Getter;

/**
 * 文章发表状态
 */
@Getter
public enum HistoryEnums {
    SHOW(1,"显示记录"),
    CLOSE(0,"不显示记录");

    private Integer code;
    private String msg;
    HistoryEnums(Integer code, String msg){
        this.code=code;
        this.msg=msg;
    }
}
