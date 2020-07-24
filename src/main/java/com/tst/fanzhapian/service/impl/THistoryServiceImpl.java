package com.tst.fanzhapian.service.impl;

import com.tst.fanzhapian.entity.THistory;
import com.tst.fanzhapian.enums.HistoryEnums;
import com.tst.fanzhapian.mapper.THistoryMapper;
import com.tst.fanzhapian.service.ITHistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tst.fanzhapian.util.KeyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 浏览记录表 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@Service
@Transactional
public class THistoryServiceImpl extends ServiceImpl<THistoryMapper, THistory> implements ITHistoryService {

    @Autowired
    private THistoryMapper tHistoryMapper;

    /**
     * 查询全部浏览历史
     * @return
     */
    @Override
    public List<THistory> getAllHistory() {
        return tHistoryMapper.getAllHistory();
    }

    /**
     * 新增浏览历史
     * @param tHistory
     * @return
     */
    @Override
    public boolean saveHistory(THistory tHistory) {
        //主键
        tHistory.setId(KeyUtils.genUniqueKey());
        return this.save(tHistory);
    }

    /**
     * 删除浏览历史
     * @param tHistory
     * @return
     */
    @Override
    public boolean dieHistory(THistory tHistory) {
        tHistory.setStatu(HistoryEnums.CLOSE.getCode());
        return updateById(tHistory);
    }
}
