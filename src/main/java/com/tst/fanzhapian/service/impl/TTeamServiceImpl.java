package com.tst.fanzhapian.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tst.fanzhapian.entity.TTeam;
import com.tst.fanzhapian.mapper.TTeamMapper;
import com.tst.fanzhapian.service.ITTeamService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
public class TTeamServiceImpl extends ServiceImpl<TTeamMapper, TTeam> implements ITTeamService {


}
