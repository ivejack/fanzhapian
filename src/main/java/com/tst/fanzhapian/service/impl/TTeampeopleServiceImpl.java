package com.tst.fanzhapian.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tst.fanzhapian.entity.TTeampeople;
import com.tst.fanzhapian.mapper.TTeampeopleMapper;
import com.tst.fanzhapian.service.ITTeampeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 团员表 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-07-21
 */
@Service
@Transactional
public class TTeampeopleServiceImpl extends ServiceImpl<TTeampeopleMapper, TTeampeople> implements ITTeampeopleService {

    @Autowired
    private TTeampeopleMapper tTeampeopleMapper;

    /**
     * 成员信息查询
     * @param id
     * @return
     */
    @Override
    public List<TTeampeople> getMyTeamPeople(String id) {
        return tTeampeopleMapper.getMyTeamPeople(id);
    }
}
