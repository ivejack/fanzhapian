package com.tst.fanzhapian.service;

import com.tst.fanzhapian.entity.TModul;
import com.tst.fanzhapian.entity.TRoleModul;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色模板表 服务类
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
public interface ITRoleModulService extends IService<TRoleModul> {

    /** 根据角色编号查询该角色所有模块 */
    List<TModul> getByRoleID(String id);
}
