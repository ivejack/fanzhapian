package com.tst.fanzhapian.mapper;

import com.tst.fanzhapian.entity.TEssay;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 文章表  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@Component
public interface TEssayMapper extends BaseMapper<TEssay> {

    /** 查询所有文章  分页，模糊  根据文章标题进行模糊查询*/
    List<TEssay> getTEssayByLikeAndPage(@Param("title") String title);
    /** 后台 */
    List<TEssay> getTEssayByLikeAndPageManager(@Param("title") String title);
    /** 查看单篇文章详情 */
    TEssay getOneTEssay(@Param("id") String id);
    /** 修改 */
    boolean gotoEssay(@Param("id") String id , @Param("statu") Integer statu);
    /** 查询文章总数 */
    Integer getCountEssayByUserid(@Param("userid") String userid);

}

