package com.tst.fanzhapian.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.tst.fanzhapian.entity.TVip;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
public interface ITVipService extends IService<TVip> {
    /** 模糊分页查询  （通过用户名查询） */
    PageInfo<TVip> getVIPByLikeAndPage(Integer pageNum, Integer pageSize, String username);
    /** 查询单个详情 */
    TVip getOneVip(String id);
    /** 增加积分   (积分来源：个人积分（考试<ok>，浏览文章<ok>，发表文章<ok>，举报<ok>，拉朋友），团队积分)*/
    boolean addScore(String id,String score);
}
