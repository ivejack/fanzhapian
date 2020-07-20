package com.tst.fanzhapian.service;

import com.tst.fanzhapian.entity.TRole;
import com.tst.fanzhapian.entity.TUserRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
public interface ITUserRoleService extends IService<TUserRole> {

    /** 根据用户编号查询角色 */
    TRole getByUserId(String id);

}
