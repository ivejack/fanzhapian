package com.tst.fanzhapian.service;

import com.github.pagehelper.PageInfo;
import com.tst.fanzhapian.entity.TCheck;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 审核表  服务类
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
public interface ITCheckService extends IService<TCheck> {

    /**  查询审核 分页，模糊，全部 根据审核状态，*/
    PageInfo<TCheck> getTCheckByLikeAndPage(Integer type,Integer result,Integer checkStatu,Integer pageNum,Integer pageSize);
    /**  新增审核 */
    boolean saveCheck(TCheck tCheck);
    /**  进行审核  发表 */
    boolean goCheck(String id,String userid,Integer result);
    /**  进行审核   举报*/
    boolean gotoCheckReport(String id,String userid,Integer result);
}
