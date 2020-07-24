package com.tst.fanzhapian.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class TApply implements Serializable {

    private  String id;

    //申请人id
    private String applyId;
    private TUser applyIds;

    //接收人id
    private String replyId;
    private TUser replyIds;

    //附加内容
    private String message;
}
