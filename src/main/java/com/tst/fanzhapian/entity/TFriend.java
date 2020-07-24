package com.tst.fanzhapian.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class TFriend implements Serializable {
    private  String id;


    private String friendId;

    private TUser userId;

    private String type;
}
