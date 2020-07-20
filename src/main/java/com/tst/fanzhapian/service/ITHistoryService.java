package com.tst.fanzhapian.service;

import com.tst.fanzhapian.entity.THistory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 浏览记录表 服务类
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
public interface ITHistoryService extends IService<THistory> {

    /** 查询全部浏览历史 */
    List<THistory> getAllHistory();
    /** 新增浏览历史 */
    boolean saveHistory(THistory tHistory);
    /** 删除浏览历史 */
    boolean dieHistory(THistory tHistory);

}
