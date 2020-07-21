package com.tst.fanzhapian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tst.fanzhapian.entity.TTeam;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 团队表 Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-07-21
 */
@Component
public interface TTeamMapper extends BaseMapper<TTeam> {
    //根据userid查询teamid
    TTeam getTeamidByUserid(@Param("userid") String userid);
    //后台查询
    List<TTeam> getTeamList(@Param("name")String name);
    //删除
    boolean delTeam(@Param("id")String id);
}
