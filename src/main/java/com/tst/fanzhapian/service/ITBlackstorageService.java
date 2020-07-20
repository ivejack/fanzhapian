package com.tst.fanzhapian.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tst.fanzhapian.entity.TBlackstorage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 黑库表 服务类
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
public interface ITBlackstorageService extends IService<TBlackstorage> {

    /** 查询所有 ，模糊，分页  后台*/
    IPage<TBlackstorage> getPageTBlack(String typecontent,Integer pageNum,Integer pageSize);
    /** 删除 */
    boolean delBlack(String id);
    /** 修改 */
    boolean updBlack(TBlackstorage tBlackstorage);
    /** 新增 */
    boolean saveBlack(TBlackstorage tBlackstorage);
    /** 查询单个*/
    TBlackstorage getOneTBlack(String id);
    /** 查询所有 ，模糊  前台*/
    List<TBlackstorage> getTBlack(String typecontent);

}
