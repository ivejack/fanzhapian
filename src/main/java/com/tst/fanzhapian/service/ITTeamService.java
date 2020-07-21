package com.tst.fanzhapian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.tst.fanzhapian.entity.TTeam;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 团队表 服务类
 * </p>
 *
 * @author jobob
 * @since 2020-07-21
 */
public interface ITTeamService extends IService<TTeam> {
    //根据userid查询teamid
    TTeam getTeamidByUserid(String userid);
    //后台查询
    PageInfo<TTeam> getTeamList(Integer pageNum, Integer pageSize, String name);
    //删除
    boolean delTeam(String id);
}
