package com.tst.fanzhapian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tst.fanzhapian.entity.TTeampeople;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 团员表 Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-07-21
 */
@Component
public interface TTeampeopleMapper extends BaseMapper<TTeampeople> {
    /** 成员信息查询 */
    List<TTeampeople> getMyTeamPeople(@Param("id") String id);
}
