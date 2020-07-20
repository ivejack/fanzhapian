package com.tst.fanzhapian.service;

import com.tst.fanzhapian.entity.TModul;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 模板表 服务类
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
public interface ITModulService extends IService<TModul> {

    /** 根据模板编号查询模板信息 */
    TModul getByModulID(String id);

}
