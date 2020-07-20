package com.tst.fanzhapian.service.impl;

import com.tst.fanzhapian.entity.TRole;
import com.tst.fanzhapian.mapper.TRoleMapper;
import com.tst.fanzhapian.service.ITRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@Service
@Transactional
public class TRoleServiceImpl extends ServiceImpl<TRoleMapper, TRole> implements ITRoleService {

    /**
     * 根据角色编号查询角色信息
     * @param id
     * @return
     */
    @Override
    public TRole getRole(String id) {
        return this.getById(id);
    }
}
