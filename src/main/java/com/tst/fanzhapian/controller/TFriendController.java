package com.tst.fanzhapian.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;

import com.tst.fanzhapian.entity.TApply;
import com.tst.fanzhapian.entity.TFriend;
import com.tst.fanzhapian.entity.TUser;
import com.tst.fanzhapian.enums.UserEnums;
import com.tst.fanzhapian.service.ITApplyService;
import com.tst.fanzhapian.service.ITFriendService;
import com.tst.fanzhapian.service.ITUserService;
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
    @Autowired
    private ITUserService itUserService;


    /**
     * 查询全部好友
     * @return
     */
    @RequestMapping("/getTFriendList")
    public PageInfo<TFriend> getTFriendList(Integer pageNum){
        pageNum=pageNum==null?1:pageNum;
        Integer pageSize=5;
//        System.out.println("getTFriendList");
//        itFriendService.getTFriendByLikeAndPage(type,pageNum,pageSize).getList().forEach(System.out::println);
        return itFriendService.getTFriendByLikeAndPage(pageNum,pageSize);
    }

    /**
     * 查询用户
     * @return
     */
    @RequestMapping("/getonefriendtouser")
    public TUser getOneFriend(String id){
        return itUserService.queryOneUser(id);
    }

    /**
     * 查询全部用户
     * @return
     */
    @RequestMapping("/getTAddFriendList")
    public IPage<TUser> getTAddFriendList(Integer pageNum,String username){
//        System.out.println("1:"+pageNum);
//        System.out.println("2:"+username);
        pageNum = pageNum==null?1:pageNum;
        Integer pageSize=5;
        TUser tUser = new TUser();
        if (username!=null){
            tUser.setUsername(username);
        }
        tUser.setStatu(UserEnums.LIVING.getCode());
        return itUserService.listUserByLikeAndPage(pageNum, pageSize, tUser);
    }

    /**
     * 发送附加消息
     * @param request
     * @param userid
     * @param message
     * @return
     */
    @RequestMapping("/sendNews")
    public boolean friendNews(HttpServletRequest request,String userid,String message){
        String user = (String) request.getSession().getAttribute("userid");
        System.out.println(user);
        TApply tApply = new TApply();
        tApply.setApplyId(user);
        tApply.setReplyId(userid);
        tApply.setMessage(message);
        System.out.println(tApply);
        Boolean aBoolean = itApplyService.saveNews(tApply);
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            objectMapper.writeValue(System.out,aBoolean);
//        } catch (IOException e) {
//           e.printStackTrace();
//        }
        return aBoolean;
    }

    /**
     * 查询好友申请
     * @return
     */
    @RequestMapping("/getTFriendNewsList")
    public PageInfo<TApply> getTFriendNewsList(HttpServletRequest request,Integer pageNum){
        String user = (String) request.getSession().getAttribute("userid");
        pageNum=pageNum==null?1:pageNum;
        Integer pageSize=5;
        return itApplyService.getTAddFriendNewsByLikeAndPage(user,pageNum,pageSize);
    }


    /**
     * 同意消息
     * @param request
     * @param applyid
     * @param replyid
     * @return
     */
    @RequestMapping("/gotoNews")
    public boolean gotoNews(HttpServletRequest request,String applyid,String replyid){
        System.out.println("ApplyID:"+applyid);
        System.out.println("ReplyID:"+replyid);
        TFriend tFriend = new TFriend();
        tFriend.setUserid(applyid);
        tFriend.setFriendId(replyid);
        Boolean aBoolean = itFriendService.addFriend(tFriend);
        System.out.println("同意："+aBoolean);
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            objectMapper.writeValue(System.out,aBoolean);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
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




