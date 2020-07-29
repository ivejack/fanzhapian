package com.tst.fanzhapian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tst.fanzhapian.entity.TApply;
import com.tst.fanzhapian.entity.TFriend;
import com.tst.fanzhapian.entity.TUser;
import com.tst.fanzhapian.mapper.TApplyMapper;
import com.tst.fanzhapian.mapper.TFriendMapper;
import com.tst.fanzhapian.service.ITApplyService;
import com.tst.fanzhapian.service.ITFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TFriendServiceImpl extends ServiceImpl<TFriendMapper, TFriend> implements ITFriendService {

    @Autowired
    private TFriendMapper tFriendMapper;
    @Autowired
    private TApplyMapper tApplyMapper;
    @Autowired
    private ITFriendService itFriendService;
    @Autowired
    private ITApplyService itApplyService;

    /**
     * 查询好友
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<TFriend> getTFriendByLikeAndPage( Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<TFriend> tFriendByLikeAndPage = tFriendMapper.getTFriendByLikeAndPage();
        return new PageInfo<TFriend>(tFriendByLikeAndPage);
    }

    /**
     * 查询陌生人
     * @param type
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<TFriend> getTAddFriendByLikeAndPage(String type, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<TFriend> tAddFriendByLikeAndPage = tFriendMapper.getTAddFriendByLikeAndPage(type);
        return new PageInfo<TFriend>(tAddFriendByLikeAndPage);
    }

    @Override
    public boolean addFriend(TFriend tFriend) {
        Integer s = new Integer(tFriendMapper.selectFriendMaxId());
        s+=1;
        //设置id
        tFriend.setId(s.toString());
//        System.out.println(tFriend.getId());
        return tFriendMapper.addFriend(tFriend);
//        return false;
    }


}
