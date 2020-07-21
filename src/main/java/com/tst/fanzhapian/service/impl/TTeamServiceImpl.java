package com.tst.fanzhapian.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tst.fanzhapian.entity.TTeam;
import com.tst.fanzhapian.mapper.TTeamMapper;
import com.tst.fanzhapian.service.ITTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 团队表 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-07-21
 */
@Service
@Transactional
public class TTeamServiceImpl extends ServiceImpl<TTeamMapper, TTeam> implements ITTeamService {

    @Autowired
    private TTeamMapper tTeamMapper;

    @Override
    public TTeam getTeamidByUserid(String userid) {
        return tTeamMapper.getTeamidByUserid(userid);
    }

    @Override
    public PageInfo<TTeam> getTeamList(Integer pageNum, Integer pageSize, String name) {
        PageHelper.startPage(pageNum,pageSize);
        List<TTeam> list = tTeamMapper.getTeamList(name);
        PageInfo<TTeam> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public boolean delTeam(String id) {
        return tTeamMapper.delTeam(id);
    }
}
