package com.tst.fanzhapian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tst.fanzhapian.entity.TModul;
import com.tst.fanzhapian.entity.TRoleModul;
import com.tst.fanzhapian.mapper.TRoleModulMapper;
import com.tst.fanzhapian.service.ITModulService;
import com.tst.fanzhapian.service.ITRoleModulService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 角色模板表 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@Service
@Transactional
public class TRoleModulServiceImpl extends ServiceImpl<TRoleModulMapper, TRoleModul> implements ITRoleModulService {

    @Autowired
    private ITModulService itModulService;

    /**
     * 根据角色编号查询该角色所有模块
     * @param id
     * @return
     */
    @Override
    public List<TModul> getByRoleID(String id) {
        QueryWrapper<TRoleModul> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("roleid",id);
        List<TRoleModul> list = this.list(queryWrapper);
        List<String> ids = new ArrayList<>();
        for (TRoleModul modul: list) {
            ids.add(modul.getModulid());
        }
        return itModulService.listByIds(ids);
    }
}
