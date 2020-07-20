package com.tst.fanzhapian.exception;


import com.tst.fanzhapian.enums.ResultEnum;

public class FanzhapianException extends RuntimeException {

    private Integer code;

    public FanzhapianException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public FanzhapianException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
