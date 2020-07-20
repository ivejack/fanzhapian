package com.tst.fanzhapian.service;

import com.tst.fanzhapian.entity.TTest;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 题目表 服务类
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
public interface ITTestService extends IService<TTest> {
    /** 查询全部 */
    List<TTest> getAllTest();
    /** 查询单个*/
    TTest getOneTest(@Param("id") String id);
    /** 查询单个通过用户id */
    List<TTest> getOneTestByUserID(@Param("id") String id);
    /** 新增 */
    boolean saveTest(TTest tTest);
}
