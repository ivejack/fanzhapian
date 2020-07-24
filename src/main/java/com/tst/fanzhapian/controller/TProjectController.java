package com.tst.fanzhapian.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tst.fanzhapian.entity.TBlackstorage;
import com.tst.fanzhapian.entity.TProject;
import com.tst.fanzhapian.service.ITProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * <p>
 * 项目表 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-07-21
 */
@RestController
public class TProjectController{

    @Autowired
    private ITProjectService itProjectService;

    /**
     * 项目列表
     * @param pageNum 当前页
     * @param name  项目名
     * @return
     */
    @RequestMapping(value = {"/getProjectList","/sys/getProjectList"})
    public IPage<TProject> getProjectList(Integer pageNum,String name){
        return itProjectService.getAllproject(pageNum,name);
    }

    /**
     * 单个查询
     * @param id 项目id
     * @return
     */
    @RequestMapping("/sys/getOneProject")
    public TProject getOneProject(String id){
        return itProjectService.getOneProject(id);
    }

    /**
     * 新增，修改
     * @param tProject 项目实体类
     * @return
     */
    @RequestMapping("/sys/saveorupdate")
    public boolean saveorupdate(TProject tProject){
        if (tProject.getId().equals("-1")){
            return itProjectService.saveProject(tProject);
        }else {
            return itProjectService.updProject(tProject);
        }
    }

    /**
     * 删除
     * @param id 项目id
     * @return
     */
    @RequestMapping("/sys/delproject")
    public boolean delProject(String id){
        return itProjectService.delProject(id);
    }

}
