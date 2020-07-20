package com.tst.fanzhapian.service;

import com.github.pagehelper.PageInfo;
import com.tst.fanzhapian.entity.TEssay;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 文章表  服务类
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
public interface ITEssayService extends IService<TEssay> {

    /** 查询所有文章，模糊，分页 */
    PageInfo<TEssay> getTEssayByLikeAndPage(Integer pageNum,Integer pageSize,String title);
    /**后台*/
    PageInfo<TEssay> getTEssayByLikeAndPageManager(Integer pageNum,Integer pageSize,String title);
    /** 查看单篇文章详情 */
    TEssay getOneTEssay(String id);
    /** 修改 */
    boolean gotoEssay(@Param("id") String id , @Param("statu") Integer statu);
    /** 查询文章总数 */
    Integer getCountEssayByUserid(@Param("userid") String userid);
    /** 发表文章 */
    boolean saveTEssay(TEssay tEssay);
    /** 删除文章（注销） */
    boolean dieTEssay(TEssay tEssay);
}
