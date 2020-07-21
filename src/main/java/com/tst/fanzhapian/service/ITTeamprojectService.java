package com.tst.fanzhapian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tst.fanzhapian.entity.TTeamproject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 团队项目表 服务类
 * </p>
 *
 * @author jobob
 * @since 2020-07-21
 */
public interface ITTeamprojectService extends IService<TTeamproject> {
    /** 项目查询 */
    List<TTeamproject> getMyProject(String id);
    /** 新增我的项目 */
    boolean addproject(String teamid, String projectid);
    /** 删除我的项目 */
    boolean delproject(String teamid, String projectid);
    /** 单个查询 */
    TTeamproject getOneProject(String teamid,String projectid);
}
