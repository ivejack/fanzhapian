package com.tst.fanzhapian.mapper;

import com.tst.fanzhapian.entity.THistory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 浏览记录表 Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@Component
public interface THistoryMapper extends BaseMapper<THistory> {

    /** 查询全部浏览历史 */
    List<THistory> getAllHistory();
}
