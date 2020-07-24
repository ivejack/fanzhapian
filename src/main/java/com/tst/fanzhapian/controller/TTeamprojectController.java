package com.tst.fanzhapian.controller;


import com.tst.fanzhapian.entity.TTeam;
import com.tst.fanzhapian.entity.TTeamproject;
import com.tst.fanzhapian.service.ITTeamService;
import com.tst.fanzhapian.service.ITTeamprojectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 团队项目表 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-07-21
 */
@RestController
public class TTeamprojectController {

    @Autowired
    private ITTeamprojectService itTeamprojectService;
    @Autowired
    private ITTeamService itTeamService;
    /**
     * 我的项目查询
     * @return
     */
    @RequestMapping("/getMyProject")
    public List<TTeamproject> getMyProject(HttpServletRequest request){
        String id = (String) request.getSession().getAttribute("userid");
        return itTeamprojectService.getMyProject(id);
    }

    /**
     * 删除我的项目
     * @param id 项目id
     * @return
     */
    @RequestMapping("/delproject")
    public boolean delproject(HttpServletRequest request,String id){
        String userid = (String) request.getSession().getAttribute("userid");
        TTeam team = itTeamService.getTeamidByUserid(userid);

        return itTeamprojectService.delproject(team.getId(),id);
    }

    /**
     * 新增我的项目
     * @param id 项目id
     * @return
     */
    @RequestMapping("/addproject")
    public boolean addproject(HttpServletRequest request,String id){
        String userid = (String) request.getSession().getAttribute("userid");
        TTeam team = itTeamService.getTeamidByUserid(userid);
        TTeamproject one = itTeamprojectService.getOneProject(team.getId(),id);
        //判断项目是否存在
        if (one!=null){
            return false;
        }else {
            return itTeamprojectService.addproject(team.getId(),id);
        }
    }
}
