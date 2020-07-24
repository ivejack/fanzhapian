package com.tst.fanzhapian.controller;


import com.github.pagehelper.PageInfo;
import com.tst.fanzhapian.entity.TCheck;
import com.tst.fanzhapian.entity.TEssay;
import com.tst.fanzhapian.entity.TVip;
import com.tst.fanzhapian.enums.CheckTypeEnums;
import com.tst.fanzhapian.enums.EssayEnums;
import com.tst.fanzhapian.service.ITCheckService;
import com.tst.fanzhapian.service.ITEssayService;
import com.tst.fanzhapian.service.ITVipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * <p>
 * 文章表  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@RestController
public class TEssayController{
    @Autowired
    private ITEssayService itEssayService;
    @Autowired
    private ITCheckService itCheckService;

    /**
     * 全部查询
     * @param title 文章标题
     * @param  pageNum 当前页
     * @return
     */
    @RequestMapping("/getTEssayList")
    public PageInfo<TEssay> getTEssayList(String title,Integer pageNum){
//        System.out.println(pageNum);
        pageNum=pageNum==null?1:pageNum;
        Integer pageSize=6;
//        System.out.println(pageNum);
        return itEssayService.getTEssayByLikeAndPage(pageNum,pageSize,title);
    }

    /**
     * 后台
     * @param title 文章标题
     * @param  pageNum 当前页
     * @return
     */
    @RequestMapping("/sys/getTEssayByLikeAndPageManager")
    public PageInfo<TEssay> getTEssayByLikeAndPageManager(String title,Integer pageNum){
//        System.out.println(pageNum);
        pageNum=pageNum==null?1:pageNum;
        Integer pageSize=6;
//        System.out.println(pageNum);
        return itEssayService.getTEssayByLikeAndPageManager(pageNum,pageSize,title);
    }

    /**
     * 单个查询
     * @param id 文章id
     * @return
     */
    @RequestMapping("/getOneEssay")
    public TEssay getOneEssay(HttpServletRequest request ,String id){
        TEssay tEssay = itEssayService.getOneTEssay(id);
        //添加开始浏览时间
        request.getSession().setAttribute("starttime",new Date().getTime());
        return tEssay;
    }

    /**
     * 举报
     * @param id 文章id
     * @return
     */
    @RequestMapping("/addTheck")
    public boolean addTheck(String  id, HttpServletRequest request){
        TCheck tCheck = new TCheck();
        //类型
        tCheck.setType(CheckTypeEnums.REPORT.getCode());
        //举报人
        String userid = (String) request.getSession().getAttribute("userid");
        tCheck.setUserid(userid);
        //举报文章
        tCheck.setContentid(id);

        return itCheckService.saveCheck(tCheck);
    }

    /**
     * 文章发表
     * @param request 当前用户，发表人
     * @param title  文章标题
     * @param content  文章内容
     * @return
     */
    @RequestMapping("/publishEssay")
    public boolean saveEssay(HttpServletRequest request,String title,String content){
        TEssay tEssay = new TEssay();
        tEssay.setTitle(title);
        tEssay.setContent(content);
        tEssay.setUserid((String)request.getSession().getAttribute("userid"));
        return itEssayService.saveTEssay(tEssay);
    }


    /**
     *
     * @param id  文章id
     * @param statu 文章发表状态
     * @return
     */
    @RequestMapping("/sys/updOrdel")
    public boolean updOrdel(String id,String statu){
        Integer i = 0;
        if (statu.equals("发表")){
            i=1;
        }else {
            i=0;
        }
        return itEssayService.gotoEssay(id,i);
    }

}
