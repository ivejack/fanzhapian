package com.tst.fanzhapian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tst.fanzhapian.entity.TTeamproject;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 团队项目表 Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-07-21
 */
@Component
public interface TTeamprojectMapper extends BaseMapper<TTeamproject> {
    /** 我的项目查询 */
    List<TTeamproject> getMyProject(@Param("id") String id);
    /** 新增我的项目 */
    boolean addproject(@Param("teamid") String teamid,@Param("projectid") String projectid);
    /** 删除我的项目 */
    boolean delproject(@Param("teamid") String teamid,@Param("projectid") String projectid);
    /** 单个查询 */
    TTeamproject getOne(@Param("teamid") String teamid,@Param("projectid") String projectid);
}
