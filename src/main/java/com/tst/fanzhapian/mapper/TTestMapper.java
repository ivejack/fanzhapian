package com.tst.fanzhapian.mapper;

import com.tst.fanzhapian.entity.TTest;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 题目表 Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@Component
public interface TTestMapper extends BaseMapper<TTest> {

    /** 查询全部 */
    List<TTest> getAllTest();
    /** 查询单个*/
    TTest getOneTest(@Param("id") String id);

    List<TTest> getOneTestByUserID(@Param("id") String id);
}
