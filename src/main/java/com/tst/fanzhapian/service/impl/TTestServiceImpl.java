package com.tst.fanzhapian.service.impl;

import com.tst.fanzhapian.entity.TTest;
import com.tst.fanzhapian.mapper.TTestMapper;
import com.tst.fanzhapian.service.ITTestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 题目表 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@Service
@Transactional
public class TTestServiceImpl extends ServiceImpl<TTestMapper, TTest> implements ITTestService {

    @Autowired
    private TTestMapper tTestMapper;

    /**
     * 查询全部
     * @return
     */
    @Override
    public List<TTest> getAllTest() {
        return tTestMapper.getAllTest();
    }

    /**
     * 查询单个
     * @param id
     * @return
     */
    @Override
    public TTest getOneTest(String id) {
        return tTestMapper.getOneTest(id);
    }

    /**
     * 查询单个通过用户id
     * @param id
     * @return
     */
    @Override
    public List<TTest> getOneTestByUserID(String id) {
        return tTestMapper.getOneTestByUserID(id);
    }

    /**
     * 新增
     * @param tTest
     * @return
     */
    @Override
    public boolean saveTest(TTest tTest) {
        return this.save(tTest);
    }
}
