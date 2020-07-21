package com.tst.fanzhapian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tst.fanzhapian.entity.TBlackstorage;
import com.tst.fanzhapian.entity.TProject;
import com.tst.fanzhapian.mapper.TProjectMapper;
import com.tst.fanzhapian.service.ITProjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 项目表 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-07-21
 */
@Service
@Transactional
public class TProjectServiceImpl extends ServiceImpl<TProjectMapper, TProject> implements ITProjectService {

    /**
     * 查询所有项目列表
     * @return
     */
    @Override
    public IPage<TProject> getAllproject(Integer pageNum,String name) {
        QueryWrapper<TProject> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name",name);
        Integer pageSize=5;
        Page<TProject> page = new Page<>(pageNum,pageSize);
        return this.page(page,queryWrapper);
    }

    @Override
    public TProject getOneProject(String id) {
        return this.getById(id);
    }

    @Override
    public boolean saveProject(TProject tProject) {
        QueryWrapper<TProject> queryWrapper =new QueryWrapper<>();
        queryWrapper.inSql("id","select max(convert(id,signed)) from t_project");
        //查询主键最大值
        TProject one = this.getOne(queryWrapper);
        //设置主键
        if (one==null){
            tProject.setId("0");
        }else {
            Integer integer = new Integer(one.getId());
            integer+=1;
            tProject.setId(integer.toString());
        }
        return this.save(tProject);
    }

    @Override
    public boolean updProject(TProject tProject) {
        return this.updateById(tProject);
    }

    @Override
    public boolean delProject(String id) {
        return this.removeById(id);
    }
}
