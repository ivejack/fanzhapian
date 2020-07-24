package com.tst.fanzhapian.controller;


import com.github.pagehelper.PageInfo;
import com.tst.fanzhapian.entity.TCheck;
import com.tst.fanzhapian.enums.CheckStatuEnums;
import com.tst.fanzhapian.enums.CheckTypeEnums;
import com.tst.fanzhapian.service.ITCheckService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 审核表  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@RestController
@RequestMapping("/sys")
public class TCheckController{
    @Autowired
    private ITCheckService itCheckService;

    /**
     * 模糊查询，分页
     * 文章发表 0
     * @param pageNow 当前页
     * @param statu     审核状态
     * @param result    审核结果
     * @return
     */
    @RequestMapping("/getCheckPublishEssay")
    public PageInfo<TCheck> getCheckPublishEssay(Integer pageNow, Integer statu, Integer result){
        Integer pageSize=3;
        statu = statu==-1?null:statu;
        result = result==-1?null:result;
        Integer type=0;
        PageInfo<TCheck> tCheckByLikeAndPage = itCheckService.getTCheckByLikeAndPage(type,result,statu, pageNow, pageSize);
//        tCheckByLikeAndPage.getList().forEach(System.out::println);
        return tCheckByLikeAndPage;
    }

    /**
     * 模糊查询，分页
     * 文章举报 1
     * @param pageNow 当前页
     * @param statu     审核状态
     * @param result    审核结果
     * @return
     */
    @RequestMapping("/getCheckReport")
    public PageInfo<TCheck> getCheckReport(Integer pageNow, Integer statu, Integer result){
        Integer pageSize=3;
        statu = statu==-1?null:statu;
        result = result==-1?null:result;
        Integer type=1;
        PageInfo<TCheck> tCheckByLikeAndPage = itCheckService.getTCheckByLikeAndPage(type,result,statu, pageNow, pageSize);
//        tCheckByLikeAndPage.getList().forEach(System.out::println);
        return tCheckByLikeAndPage;
    }

    /**
     * 审核
     * 发表
     * @param request
     * @param id        审核编号
     * @param result     审核结果
     * @return
     */
    @RequestMapping("/gotoCheck")
    public boolean gotoCheck(HttpServletRequest request,String id,Integer result){
        return itCheckService.goCheck(id,(String)request.getSession().getAttribute("userid"),result);
    }

    /**
     * 审核
     * 举报
     * @param request
     * @param id        审核编号
     * @param result     审核结果
     * @return
     */
    @RequestMapping("/gotoCheckReport")
    public boolean gotoCheckReport(HttpServletRequest request,String id,Integer result){
        return itCheckService.gotoCheckReport(id,(String)request.getSession().getAttribute("userid"),result);
    }

    /**
     * 审核
     * 举报
     * 删除
     * @param id 审核编号
     * @return
     */
    @RequestMapping("/delCheck")
    public boolean delCheck(String id){
        return itCheckService.delCheck(id);
    }


}
