package com.tst.fanzhapian.controller;


import com.github.pagehelper.PageInfo;
import com.tst.fanzhapian.entity.TTeam;
import com.tst.fanzhapian.service.ITTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 团队表 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-07-21
 */
@RestController
public class TTeamController {
    @Autowired
    private ITTeamService itTeamService;

    /**
     * 查询全部
     * @param pageNum 当前页
     * @param name  团队名
     * @return
     */
    @RequestMapping("/sys/getTeamList")
    public PageInfo<TTeam> getTeamList(Integer pageNum,String name){
//        System.out.println(pageNum);
//        System.out.println(name);
        Integer pageSize =5 ;
        PageInfo<TTeam> teamList = itTeamService.getTeamList(pageNum, pageSize, name);
//        System.out.println("tttt:"+teamList);
        return teamList;
    }

    /**
     *
     * @param id 团队id
     * @return
     */
    //删除
    @RequestMapping("/sys/delTeam")
    public boolean delTeam(String id){
        return itTeamService.delTeam(id);
    }
}
