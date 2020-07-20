package com.tst.fanzhapian.controller;


import com.github.pagehelper.PageInfo;
import com.tst.fanzhapian.entity.TCheck;
import com.tst.fanzhapian.entity.TEssay;
import com.tst.fanzhapian.enums.CheckTypeEnums;
import com.tst.fanzhapian.enums.EssayEnums;
import com.tst.fanzhapian.service.ITCheckService;
import com.tst.fanzhapian.service.ITEssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
     * @param id
     * @return
     */
    @RequestMapping("/getOneEssay")
    public TEssay getOneEssay(String id){
        return itEssayService.getOneTEssay(id);
    }

    /**
     * 举报
     * @param id
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
     * @param request
     * @param title
     * @param content
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
