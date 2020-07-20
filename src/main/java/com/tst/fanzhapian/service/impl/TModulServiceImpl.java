package com.tst.fanzhapian.service.impl;

import com.tst.fanzhapian.entity.TModul;
import com.tst.fanzhapian.mapper.TModulMapper;
import com.tst.fanzhapian.service.ITModulService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 模板表 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@Service
@Transactional
public class TModulServiceImpl extends ServiceImpl<TModulMapper, TModul> implements ITModulService {

    /**
     * 根据模板编号查询模板信息
     * @param id
     * @return
     */
    @Override
    public TModul getByModulID(String id) {
        return this.getById(id);
    }
}
