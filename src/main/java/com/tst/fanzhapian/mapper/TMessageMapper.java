package com.tst.fanzhapian.mapper;

import com.tst.fanzhapian.entity.TMessage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 内容表 Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@Component
public interface TMessageMapper extends BaseMapper<TMessage> {
    /** 查询消息，分页，模糊，全部 */
    List<TMessage> getTMessageBylikeAndPage(@Param("typeid") String typeid);
    /** 查询单个消息 */
    TMessage getOneMessage(@Param("id") String id);
    /** 新增消息 */

}
