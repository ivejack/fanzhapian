package com.tst.fanzhapian.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class TFriend implements Serializable {
    private  String id;

    private String friendId;
    private TUser friendIds;

    private String userid;

    private TUser userIds;

    private String type;
}
