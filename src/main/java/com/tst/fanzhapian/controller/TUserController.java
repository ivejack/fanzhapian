package com.tst.fanzhapian.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.tst.fanzhapian.entity.TRole;
import com.tst.fanzhapian.entity.TTest;
import com.tst.fanzhapian.entity.TUser;
import com.tst.fanzhapian.entity.TVip;
import com.tst.fanzhapian.enums.UserEnums;
import com.tst.fanzhapian.service.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@RestController
//@RequestMapping("/fanzhapian/t-user")
public class TUserController {

    @Autowired
    private ITUserService itUserService;
    @Autowired
    private ITVipService itVipService;
    @Autowired
    private ITTestService itTestService;
    @Autowired
    private ITEssayService itEssayService;
    @Autowired
    private ITUserRoleService itUserRoleService;

    /**
     * 登陆
     * @param request
     * @param loginname 登录名
     * @param password  密码
     * @return
     */
    @RequestMapping("/login.action")
    public Map<String,Object> login(HttpServletRequest request, String loginname, String password){
        HttpSession session = request.getSession();
//        System.out.println("loginname "+loginname);
//        System.out.println("password "+password);
        Map<String,Object> map = new HashMap<>();
        TUser login = itUserService.login(loginname, password);
        if (login==null){
            map.put("flag",false);
        }else {
            map.put("flag",true);
            map.put("msg",login);
            session.setAttribute("username",login.getUsername());
            session.setAttribute("userid",login.getId());
            session.setAttribute("startTime",login.getStartTime());
        }
        return map;
    }

    /**
     * 后台登陆
     * @param request
     * @param loginname 登陆名
     * @param password 密码
     * @return
     */
    @RequestMapping("/admin.action")
    public Map<String,Object> Login(HttpServletRequest request, String loginname, String password){
//        System.out.println(loginname);
//        System.out.println(password);
        HttpSession session = request.getSession();
        Map<String,Object> map = new HashMap<>();
        TUser login = itUserService.login(loginname, password);
        TRole logins = itUserRoleService.getByUserId(login.getId());
        if (login==null){
            map.put("flag",false);
        } else {
            map.put("flag",true);
            map.put("msg",login);
            session.setAttribute("username",login.getUsername());
            session.setAttribute("userid",login.getId());
            session.setAttribute("startTime",login.getStartTime());
        }
        if(logins.getId().equals("2")){
            map.put("flags",true);
        }else{
            map.put("flags",false);
        }
        return map;
    }

    /**
     * 我的信息
     * @param request
     * @return
     */
    @RequestMapping("/myself")
    public Map<String,Object> myself(HttpServletRequest request){
        HttpSession session = request.getSession();
        Map<String,Object> map = new HashMap<>();
        String userid = (String) session.getAttribute("userid");
        //查询用户信息
        TUser tUser = itUserService.queryOneUser(userid);
        //查询会员信息
        TVip oneVip = itVipService.getOneVip(userid);
//      System.out.println(oneVip);
        //查询考试信息
        List<TTest> oneTestByUserID = itTestService.getOneTestByUserID(userid);
        //查询文章总数
        Integer countEssayByUserid = itEssayService.getCountEssayByUserid(userid);
        map.put("count",countEssayByUserid);
        map.put("user",tUser);
        map.put("vip",oneVip);
        map.put("test",oneTestByUserID);
        return map;
    }

    /**
     * 修改我的信息
     * @param request
     * @param name 用户名
     * @param pwd   密码
     * @param sex   性别
     * @param time  出生日期
     * @return
     */
    @RequestMapping("/updatemyself")
    public boolean updatemyself(HttpServletRequest request,String name,String pwd,Integer sex,String time){
        String userid = (String) request.getSession().getAttribute("userid");
        //查询用户信息
        TUser tUser = itUserService.queryOneUser(userid);
        //修改用户信息
        //用户名
        if (name!=null || name!=""){
            tUser.setUsername(name);
        }
        //性别
        if (sex!=null){
            tUser.setSex(sex);
        }
        //出生日期
        if (time!=null || time!=""){
            tUser.setBirthday(time);
        }
        //修改密码
        if (pwd!=null || pwd!=""){
            tUser.setPassword(pwd);
        }
       return itUserService.updateUser(tUser);
    }

    /**
     * 后台 用户管理
     * @param pageNum 当前页
     * @param tUser user实体类
     * @return
     */
    @RequestMapping("/sys/usermanager")
    public IPage<TUser> userManager(Integer pageNum, TUser tUser){
        Integer pageSize=5;
        return itUserService.listUserByLikeAndPage(pageNum,pageSize,tUser);
    }

    /**
     * 启用或注销
     * @param id    用户id
     * @param statu 用户状态
     * @return
     */
    @RequestMapping("/sys/userUpdOrdel")
    public boolean updOrdel(String id,String statu){
        TUser tUser = new TUser();
        tUser.setId(id);
        if (statu.equals("启用")){
            tUser.setStatu(UserEnums.LIVING.getCode());
        }else {
            tUser.setStatu(UserEnums.DIE.getCode());
        }
        return itUserService.updateUser(tUser);
    }

}
