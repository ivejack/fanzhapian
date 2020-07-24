package com.tst.fanzhapian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tst.fanzhapian.entity.TApply;

import com.tst.fanzhapian.entity.TFriend;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TApplyMapper extends BaseMapper<TApply> {

    Boolean saveNews(TApply tApply);

    String selectid();

    List<TApply> getTAddFriendNewsByLikeAndPage(@Param("replyId") String replyId);

    Boolean getOneFriend(TApply tApply);

    boolean delNews(@Param("id") String id);

}
