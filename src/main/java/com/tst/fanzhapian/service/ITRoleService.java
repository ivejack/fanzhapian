package com.tst.fanzhapian.service;

import com.tst.fanzhapian.entity.TRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
public interface ITRoleService extends IService<TRole> {

    /** 根据角色编号查询角色信息 */
    TRole getRole(String id);

}
