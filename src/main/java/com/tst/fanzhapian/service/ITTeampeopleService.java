package com.tst.fanzhapian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tst.fanzhapian.entity.TTeampeople;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 团员表 服务类
 * </p>
 *
 * @author jobob
 * @since 2020-07-21
 */
public interface ITTeampeopleService extends IService<TTeampeople> {
    /** 成员信息查询 */
    List<TTeampeople> getMyTeamPeople(String id);
}
