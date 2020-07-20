package com.tst.fanzhapian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tst.fanzhapian.entity.TBlackstorage;
import com.tst.fanzhapian.entity.TTeststorage;
import com.tst.fanzhapian.mapper.TBlackstorageMapper;
import com.tst.fanzhapian.service.ITBlackstorageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 黑库表 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@Service
@Transactional
public class TBlackstorageServiceImpl extends ServiceImpl<TBlackstorageMapper, TBlackstorage> implements ITBlackstorageService {

    /**
     * 查询所有 ，模糊，分页 后台
     * @param typecontent
     * @return
     */
    @Override
    public IPage<TBlackstorage> getPageTBlack(String typecontent,Integer pageNum,Integer pageSize) {
        QueryWrapper<TBlackstorage> q = new QueryWrapper<>();
        if (typecontent==null){
            q=null;
        }else {
            q.like("typecontent", typecontent);
        }
        return this.page(new Page<TBlackstorage>(pageNum,pageSize),q);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public boolean delBlack(String id) {
        return this.removeById(id);
    }

    /**
     * 修改
     * @param tBlackstorage
     * @return
     */
    @Override
    public boolean updBlack(TBlackstorage tBlackstorage) {
        return this.updateById(tBlackstorage);
    }

    /**
     * 新增
     * @param tBlackstorage
     * @return
     */
    @Override
    public boolean saveBlack(TBlackstorage tBlackstorage) {
        QueryWrapper<TBlackstorage> queryWrapper =new QueryWrapper<>();
        queryWrapper.inSql("id","select max(convert(id,signed)) from t_blackstorage");
        //查询主键最大值
        TBlackstorage one = this.getOne(queryWrapper);
        //设置主键
        if (one==null){
            tBlackstorage.setId("0");
        }else {
            Integer integer = new Integer(one.getId());
            integer+=1;
            tBlackstorage.setId(integer.toString());
        }
        return this.save(tBlackstorage);
    }

    /**
     * 查询单个
     * @param id
     * @return
     */
    @Override
    public TBlackstorage getOneTBlack(String id) {
        return this.getById(id);
    }

    /**
     * 查询所有 ，模糊，前台
     * @param typecontent
     * @return
     */
    @Override
    public List<TBlackstorage> getTBlack(String typecontent) {
        QueryWrapper<TBlackstorage> q = new QueryWrapper<>();

        q.eq("typecontent", typecontent);

        return this.list(q);
    }
}
