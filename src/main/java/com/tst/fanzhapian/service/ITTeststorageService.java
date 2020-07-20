package com.tst.fanzhapian.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tst.fanzhapian.entity.TTeststorage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 题库表 服务类
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
public interface ITTeststorageService extends IService<TTeststorage> {

    /**  查询全部,分页，模糊 */
    IPage<TTeststorage> getTestStorageAll(Integer pageNum,String question);
    /**  查询单个 */
    TTeststorage getOneTestStorage(String id);
    /**  条件查询单个 */
    TTeststorage getOneTestStorage(String id,String answer);
    /**  新增 */
    boolean saveTestStorage(TTeststorage tTeststorage);
    /**  删除 */
    boolean delTestStorage(String id);
    /**  修改 */
    boolean updTestStorage(TTeststorage tTeststorage);

}
