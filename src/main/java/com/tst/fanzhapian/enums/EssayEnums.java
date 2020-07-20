package com.tst.fanzhapian.enums;

import lombok.Getter;

/**
 * 文章发表状态
 */
@Getter
public enum EssayEnums {
    UNPUBLISH(0,"文章未发表"),
    PUBLISH(1,"文章已发表");

    private Integer code;
    private String msg;
    EssayEnums(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }
}
