package com.tst.fanzhapian.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tst.fanzhapian.entity.TTeamproject;
import com.tst.fanzhapian.mapper.TTeamprojectMapper;
import com.tst.fanzhapian.service.ITTeamprojectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 团队项目表 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-07-21
 */
@Service
@Transactional
public class TTeamprojectServiceImpl extends ServiceImpl<TTeamprojectMapper, TTeamproject> implements ITTeamprojectService {

    @Autowired
    private TTeamprojectMapper tTeamprojectMapper;

    /**
     * 我的项目查询
     * @param id
     * @return
     */
    @Override
    public List<TTeamproject> getMyProject(String id) {
        return tTeamprojectMapper.getMyProject(id);
    }

    /**
     * 新增我的项目
     * @param teamid
     * @param projectid
     * @return
     */
    @Override
    public boolean addproject(String teamid, String projectid) {
        return tTeamprojectMapper.addproject(teamid,projectid);
    }

    /**
     * 删除我的项目
     * @param teamid
     * @param projectid
     * @return
     */
    @Override
    public boolean delproject(String teamid, String projectid) {
        return tTeamprojectMapper.delproject(teamid,projectid);
    }

    @Override
    public TTeamproject getOneProject(String teamid,String projectid) {
        return tTeamprojectMapper.getOne(teamid,projectid);
    }
}
