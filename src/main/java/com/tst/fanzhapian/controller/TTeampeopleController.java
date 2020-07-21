package com.tst.fanzhapian.controller;


import com.tst.fanzhapian.entity.TTeampeople;
import com.tst.fanzhapian.service.ITTeampeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * <p>
 * 团员表 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-07-21
 */
@RestController
public class TTeampeopleController {
    @Autowired
    private ITTeampeopleService itTeampeopleService;

    /**
     * 成员查询
     * @param request
     * @return
     */
    @RequestMapping("/getMyPeople")
    public List<TTeampeople> getMyPeople(HttpServletRequest request){
        String id = (String) request.getSession().getAttribute("userid");
        List<TTeampeople> myTeamPeople = itTeampeopleService.getMyTeamPeople(id);
        return myTeamPeople;
    }


}
