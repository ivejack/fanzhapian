package com.tst.fanzhapian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.tst.fanzhapian.entity.TApply;
import com.tst.fanzhapian.entity.TFriend;

public interface ITApplyService extends IService<TApply>{

    /** 发送附加信息 */
    Boolean saveNews(TApply tApply);

    /**  分页查询所有消息 */
    PageInfo<TApply> getTAddFriendNewsByLikeAndPage(String replyId, Integer pageNum, Integer pageSize);

    /** 同意消息 */
    boolean gotoNews(TApply tApply);

    /** 删除消息 */
    boolean delNews(String id);
}
