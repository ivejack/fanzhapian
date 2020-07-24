package com.tst.fanzhapian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tst.fanzhapian.entity.TCheck;
import com.tst.fanzhapian.entity.TEssay;
import com.tst.fanzhapian.entity.TVip;
import com.tst.fanzhapian.enums.CheckStatuEnums;
import com.tst.fanzhapian.mapper.TCheckMapper;
import com.tst.fanzhapian.service.ITCheckService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tst.fanzhapian.service.ITEssayService;
import com.tst.fanzhapian.service.ITVipService;
import com.tst.fanzhapian.util.KeyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 审核表  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@Service
@Transactional
public class TCheckServiceImpl extends ServiceImpl<TCheckMapper, TCheck> implements ITCheckService {

    @Autowired
    private TCheckMapper tCheckMapper;
    @Autowired
    private ITEssayService itEssayService;
    @Autowired
    private ITVipService itVipService;

    /**
     * 查询审核 分页，模糊，全部 根据审核状态
     * @param checkStatu
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<TCheck> getTCheckByLikeAndPage(Integer type,Integer result,Integer checkStatu,Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<TCheck> tCheckByLikeAndPage = tCheckMapper.getTCheckByLikeAndPage(type,result,checkStatu);
        return new PageInfo<TCheck>(tCheckByLikeAndPage);
    }

    /**
     * 新增审核
     * @param tCheck
     * @return
     */
    @Override
    public boolean saveCheck(TCheck tCheck) {
        //主键
        tCheck.setId(KeyUtils.genUniqueKey());
        return this.save(tCheck);
    }

    /**
     * 进行审核
     * 发表
     * @param id
     * @param userid
     * @param result
     * @return
     */
    @Override
    public boolean goCheck(String id,String userid,Integer result) {
        TCheck oneCheck = tCheckMapper.getOneCheck(id);
        TEssay oneTEssay = itEssayService.getOneTEssay(oneCheck.getContentids().getId());
        if (result==1){
            oneTEssay.setStatu(0);
        }else {
            oneTEssay.setStatu(1);
            //积分变动（添加）
            String userid1 = oneTEssay.getUser().getId();
//            System.out.println("1:"+userid1);
//            System.out.println("1:"+oneTEssay);
            TVip oneVip = itVipService.getOneVip(userid1);
//            System.out.println(oneVip);
            Integer score = new Integer(oneVip.getScore());
            Integer i = 10 + score;
            itVipService.addScore(userid1,i.toString());
        }
        itEssayService.gotoEssay(oneTEssay.getId(),oneTEssay.getStatu());
        //审核
       return tCheckMapper.toCheck(id,userid,result);
    }

    /**
     * 进行审核
     * 举报
     * @param id
     * @param userid
     * @param result
     * @return
     */
    @Override
    public boolean gotoCheckReport(String id,String userid,Integer result) {
        TCheck oneCheck = tCheckMapper.getOneCheck(id);
        TEssay oneTEssay = itEssayService.getOneTEssay(oneCheck.getContentids().getId());
        if (result==1){
            //不做操作
            oneTEssay.setStatu(1);
        }else {
            //文章不能显示
            oneTEssay.setStatu(0);
            //积分变动（添加）
            String userid1 = oneTEssay.getUser().getId();
            TVip oneVip = itVipService.getOneVip(userid1);
            Integer score = new Integer(oneVip.getScore());
            Integer i = 10 + score;
            itVipService.addScore(userid1,i.toString());
        }
        itEssayService.gotoEssay(oneTEssay.getId(),oneTEssay.getStatu());
        //审核
        return tCheckMapper.toCheck(id,userid,result);
    }

    @Override
    public boolean delCheck(String id) {
        return tCheckMapper.delCheck(id);
    }
}
