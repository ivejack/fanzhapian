package com.tst.fanzhapian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.tst.fanzhapian.entity.TApply;
import com.tst.fanzhapian.entity.TFriend;
import com.tst.fanzhapian.entity.TUser;

public interface ITFriendService extends IService<TFriend>{
    /**  分页查询所有好友 */
    PageInfo<TFriend> getTFriendByLikeAndPage(String type, Integer pageNum, Integer pageSize);

    /**  分页查询所有陌生人 */
    PageInfo<TFriend> getTAddFriendByLikeAndPage(String type, Integer pageNum, Integer pageSize);


}
