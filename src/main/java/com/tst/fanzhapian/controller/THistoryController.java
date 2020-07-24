package com.tst.fanzhapian.controller;


import com.tst.fanzhapian.entity.TEssay;
import com.tst.fanzhapian.entity.THistory;
import com.tst.fanzhapian.entity.TVip;
import com.tst.fanzhapian.service.ITEssayService;
import com.tst.fanzhapian.service.ITHistoryService;
import com.tst.fanzhapian.service.ITVipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * <p>
 * 浏览记录表 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@RestController
public class THistoryController{
    @Autowired
    private ITHistoryService itHistoryService;
    @Autowired
    private ITEssayService itEssayService;
    @Autowired
    private ITVipService itVipService;

    /**
     * 记录浏览历史
     * @param request
     * @param id 文章id
     * @return
     */
    @RequestMapping("/saveHistory")
    public boolean saveHistory(HttpServletRequest request ,String id){
        Date date = new Date();
        long end = date.getTime();
        long start = (long)request.getSession().getAttribute("starttime");
        long time = end - start;
        if (time>1000*60*3){
            //积分变动（添加）
            TEssay tEssay = itEssayService.getOneTEssay(id);
            TVip oneVip = itVipService.getOneVip(tEssay.getUser().getId());
            Integer score = new Integer(oneVip.getScore());
            Integer i = 10+score;
            itVipService.addScore(tEssay.getUser().getId(),i.toString());
        }
        //添加历史记录
        THistory tHistory = new THistory();
        //浏览人
        String userid = (String)request.getSession().getAttribute("userid");
        tHistory.setUserid(userid);
        //浏览文章
        tHistory.setEssayid(id);
        return itHistoryService.saveHistory(tHistory);
    }

}
