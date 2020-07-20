package com.tst.fanzhapian.mapper;

import com.tst.fanzhapian.entity.TCheck;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 审核表  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@Component
public interface TCheckMapper extends BaseMapper<TCheck> {

    /**  查询审核 分页，模糊，全部 根据审核状态，*/
    List<TCheck> getTCheckByLikeAndPage(@Param("type") Integer type,@Param("result") Integer result,@Param("statu") Integer checkStatu);

    TCheck getOneCheck(@Param("id") String id);
    boolean toCheck(@Param("id") String id,@Param("userid") String userid,@Param("result") Integer result);
}
