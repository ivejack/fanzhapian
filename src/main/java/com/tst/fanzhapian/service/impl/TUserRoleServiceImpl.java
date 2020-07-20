package com.tst.fanzhapian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tst.fanzhapian.entity.TRole;
import com.tst.fanzhapian.entity.TUserRole;
import com.tst.fanzhapian.mapper.TUserRoleMapper;
import com.tst.fanzhapian.service.ITRoleService;
import com.tst.fanzhapian.service.ITUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@Service
@Transactional
public class TUserRoleServiceImpl extends ServiceImpl<TUserRoleMapper, TUserRole> implements ITUserRoleService {

    @Autowired
    private ITRoleService itRoleService;

    /**
     * 根据用户编号查询角色
     * @param id
     * @return
     */
    @Override
    public TRole getByUserId(String id) {
        QueryWrapper<TUserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userid",id);
        TUserRole one = this.getOne(queryWrapper);
        return itRoleService.getById(one.getRoleid());
    }
}
