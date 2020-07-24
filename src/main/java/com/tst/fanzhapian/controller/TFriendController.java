package com.tst.fanzhapian.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;

import com.tst.fanzhapian.entity.TApply;
import com.tst.fanzhapian.entity.TFriend;
import com.tst.fanzhapian.entity.TUser;
import com.tst.fanzhapian.service.ITApplyService;
import com.tst.fanzhapian.service.ITFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class TFriendController {

    @Autowired
    private ITFriendService itFriendService;
    @Autowired
    private ITApplyService itApplyService;


    /**
     * 查询全部好友
     * @return
     */
    @RequestMapping("/getTFriendList")
    public PageInfo<TFriend> getTFriendList(String type, Integer pageNum){
        pageNum=pageNum==null?1:pageNum;
        Integer pageSize=5;
        return itFriendService.getTFriendByLikeAndPage(type,pageNum,pageSize);
    }

    /**
     * 查询全部陌生人
     * @return
     */
    @RequestMapping("/getTAddFriendList")
    public PageInfo<TFriend> getTAddFriendList(String type, Integer pageNum){
        pageNum=pageNum==null?1:pageNum;
        Integer pageSize=5;
        return itFriendService.getTAddFriendByLikeAndPage(type,pageNum,pageSize);
    }

    /**
     * 发送附加消息
     * @param request
     * @param applyId
     * @param message
     * @return
     */
    @RequestMapping("/sendNews")
    public boolean friendNews(HttpServletRequest request,String applyId,String replyId,String message){
//        String user = (String) request.getSession().getAttribute("userId");
        TApply tApply = new TApply();
        tApply.setApplyId(applyId);
        tApply.setReplyId(replyId);
        tApply.setMessage(message);
        Boolean aBoolean = itApplyService.saveNews(tApply);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(System.out,aBoolean);
        } catch (IOException e) {
           e.printStackTrace();
        }
        return aBoolean;
    }

    /**
     * 查询全部消息
     * @return
     */
    @RequestMapping("/getTFriendNewsList")
    public PageInfo<TApply> getTFriendNewsList(HttpServletRequest request,String replyId,Integer pageNum){
//        String user = (String) request.getSession().getAttribute("userId");
//        TApply tApply = new TApply();
//        tApply.setReplyId(user);
        pageNum=pageNum==null?1:pageNum;
        Integer pageSize=5;
        return itApplyService.getTAddFriendNewsByLikeAndPage(replyId,pageNum,pageSize);
    }


    /**
     * 同意消息
     * @param request
     * @param applyId
     * @param replyId
     * @return
     */
    @RequestMapping("/gotoNews")
    public boolean gotoNews(HttpServletRequest request,String applyId,String replyId){
//        System.out.println("ApplyID:"+applyId);
//        System.out.println("ReplyID:"+replyId);
        TApply tApply = new TApply();
        tApply.setApplyId(applyId);
        tApply.setReplyId(replyId);
        Boolean aBoolean = itApplyService.gotoNews(tApply);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(System.out,aBoolean);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return aBoolean;
    }


    /**
     * 删除消息
     * @param id
     * @return
     */
    @RequestMapping("/delNews")
    public boolean delNews(String id){
        return itApplyService.delNews(id);
    }

}




