package com.tst.fanzhapian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.tst.fanzhapian.entity.TApply;
import com.tst.fanzhapian.entity.TFriend;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TFriendMapper extends BaseMapper<TFriend> {

    List<TFriend> getTFriendByLikeAndPage(@Param("type") String type);

    List<TFriend> getTAddFriendByLikeAndPage(@Param("type") String type);


}
