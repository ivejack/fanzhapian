package com.tst.fanzhapian.mapper;

import com.tst.fanzhapian.entity.TVip;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 会员表 Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@Component
public interface TVipMapper extends BaseMapper<TVip> {
    /** 模糊分页查询  （通过用户名查询） */
    List<TVip> getVIPByLike(@Param("username") String username);
    /** 查询单个详情 */
    TVip getOneVip(@Param("id") String id);
    /** 修改积分 */
    boolean updScore(@Param("id") String id,@Param("score") String score);
}
