package com.tst.fanzhapian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tst.fanzhapian.entity.TApply;
import com.tst.fanzhapian.entity.TFriend;
import com.tst.fanzhapian.mapper.TApplyMapper;
import com.tst.fanzhapian.mapper.TFriendMapper;
import com.tst.fanzhapian.service.ITApplyService;
import com.tst.fanzhapian.service.ITFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TApplyServiceImpl extends ServiceImpl<TApplyMapper, TApply> implements ITApplyService {
    @Autowired
    private TApplyMapper tApplyMapper;

    /**
     * 发送附加消息
     * @param
     * @return
     */
    @Override
    public Boolean saveNews(TApply tApply) {

        Integer selectid = new Integer(tApplyMapper.selectid());
        selectid+=1;
        tApply.setId(selectid.toString());
        tApply.setApplyId(tApply.getApplyId());
        tApply.setReplyId(tApply.getReplyId());
        tApply.setMessage(tApply.getMessage());

//        System.out.println("tApply:"+tApply);
        return tApplyMapper.saveNews(tApply);
    }

    @Override
    public PageInfo<TApply> getTAddFriendNewsByLikeAndPage(String replyId,Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<TApply> tAddFriendNewsByLikeAndPage = tApplyMapper.getTAddFriendNewsByLikeAndPage(replyId);
//        System.out.println(tAddFriendNewsByLikeAndPage);
        return new PageInfo<TApply>(tAddFriendNewsByLikeAndPage);
    }

    @Override
    public boolean gotoNews(TApply tApply) {
        tApply.setApplyId(tApply.getApplyId());
        tApply.setReplyId(tApply.getReplyId());
//        System.out.println("tApply:"+tApply);
        return tApplyMapper.getOneFriend(tApply);
    }

    @Override
    public boolean delNews(String id) {
        return tApplyMapper.delNews(id);
    }

}
