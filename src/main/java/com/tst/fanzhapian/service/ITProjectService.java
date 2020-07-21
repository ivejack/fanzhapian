package com.tst.fanzhapian.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tst.fanzhapian.entity.TProject;

import java.util.List;

/**
 * <p>
 * 项目表 服务类
 * </p>
 *
 * @author jobob
 * @since 2020-07-21
 */
public interface ITProjectService extends IService<TProject> {

    /** 查询所有项目列表 */
    IPage<TProject> getAllproject(Integer pageNum,String name);
    /** 查询单个 */
    TProject getOneProject(String id);
    /** 新增单个 */
    boolean saveProject(TProject tProject);
    /** 修改单个 */
    boolean updProject(TProject tProject);
    /** 删除 */
    boolean delProject(String id);
}
