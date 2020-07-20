package com.tst.fanzhapian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tst.fanzhapian.entity.TTeststorage;
import com.tst.fanzhapian.mapper.TTeststorageMapper;
import com.tst.fanzhapian.service.ITTeststorageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tst.fanzhapian.util.KeyUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 题库表 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@Service
@Transactional
public class TTeststorageServiceImpl extends ServiceImpl<TTeststorageMapper, TTeststorage> implements ITTeststorageService {

    /**
     * 查询全部,分页，模糊
     * @return
     */
    @Override
    public IPage<TTeststorage> getTestStorageAll(Integer pageNum, String question) {
        return this.page(new Page<TTeststorage>(pageNum,9),new QueryWrapper<TTeststorage>().like("question",question));
    }

    /**
     * 查询单个
     * @param id
     * @return
     */
    @Override
    public TTeststorage getOneTestStorage(String id) {
        return getById(id);
    }

    /**
     * 条件查询
     * @param id
     * @param answer
     * @return
     */
    @Override
    public TTeststorage getOneTestStorage(String id, String answer) {
        QueryWrapper<TTeststorage> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id).eq("answer",answer);
        return this.getOne(queryWrapper);
    }

    /**
     * 新增
     * @param tTeststorage
     * @return
     */
    @Override
    public boolean saveTestStorage(TTeststorage tTeststorage) {
        QueryWrapper<TTeststorage> queryWrapper =new QueryWrapper<>();
        queryWrapper.inSql("id","select max(convert(id,signed)) from t_teststorage");
        //查询主键最大值
        TTeststorage one = this.getOne(queryWrapper);
        //设置主键
        if (one==null){
            tTeststorage.setId("0");
        }else {
        Integer integer = new Integer(one.getId());
        integer+=1;
        tTeststorage.setId(integer.toString());
        }
        return save(tTeststorage);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public boolean delTestStorage(String id) {
        return this.removeById(id);
    }

    /**
     * 修改
     * @param tTeststorage
     * @return
     */
    @Override
    public boolean updTestStorage(TTeststorage tTeststorage) {
        return updateById(tTeststorage);
    }

}
