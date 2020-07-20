package com.tst.fanzhapian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tst.fanzhapian.entity.TUser;
import com.tst.fanzhapian.entity.TVip;
import com.tst.fanzhapian.mapper.TVipMapper;
import com.tst.fanzhapian.service.ITUserService;
import com.tst.fanzhapian.service.ITVipService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@Service
@Transactional
public class TVipServiceImpl extends ServiceImpl<TVipMapper, TVip> implements ITVipService {

    @Autowired
    private ITUserService itUserService;
    @Autowired
    private TVipMapper tVipMapper;

    /**
     * 模糊分页查询 （通过用户名查询）
     * @param pageNum
     * @param pageSize
     * @param username
     * @return
     */
    @Override
    public PageInfo<TVip> getVIPByLikeAndPage(Integer pageNum, Integer pageSize, String username) {
        List<TVip> vipByLike = tVipMapper.getVIPByLike(username);
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<TVip> pageInfo = new PageInfo<>(vipByLike);
        return pageInfo;
    }

    /**
     * 查询单个详情
     * @param id
     * @return
     */
    @Override
    public TVip getOneVip(String id) {
        return tVipMapper.getOneVip(id);
    }

    /**
     * 修改积分   (积分来源：个人积分（浏览文章，发表文章，举报，拉朋友），团队积分)
     * @param id
     * @param score
     * @return
     */
    @Override
    public boolean addScore(String id, String score) {
        System.out.println("????");
        return tVipMapper.updScore(id,score);
    }
}
