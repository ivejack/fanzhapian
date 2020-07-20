package com.tst.fanzhapian.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tst.fanzhapian.entity.TBlackstorage;
import com.tst.fanzhapian.service.ITBlackstorageService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 黑库表 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@RestController
public class TBlackstorageController{

    @Autowired
    private ITBlackstorageService itBlackstorageService;

    /**
     * 黑库查询（前台）
     * @return
     */
    @RequestMapping("/getTBlack")
    public Map<String,Object> getTBlack(String blacklist){
//        System.out.println("typecontent "+blacklist);
        Map<String,Object> map = new HashMap<>();
        List<TBlackstorage> tBlack = itBlackstorageService.getTBlack(blacklist);
//        System.out.println(tBlack.size());
        if (tBlack.size()<1){
            map.put("msg","该条信息诈骗嫌疑较低");
        }else {
            map.put("msg","该条信息诈骗嫌疑很高");
        }
        return map;
    }

    /**  后台  */

    /**
     * 查询所有 ，模糊，分页  后台
     * @param pageNum
     * @param typecontent
     * @return
     */
    @RequestMapping("/sys/getPageTBlack")
    public IPage<TBlackstorage> getPageTBlack(Integer pageNum,String typecontent){
        Integer pageSize = 9;
        return itBlackstorageService.getPageTBlack(typecontent,pageNum,pageSize);
    }

    /**
     * 查询单个
     * @param id
     * @return
     */
    @RequestMapping("/sys/getOneTBlack")
    public TBlackstorage getOneTBlack(String id){
        return itBlackstorageService.getOneTBlack(id);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/sys/delBlack")
    public boolean delBlack(String id){
        return itBlackstorageService.delBlack(id);
    }

    /**
     * 新增，修改
     * @param tBlackstorage
     * @return
     */
    @RequestMapping("/sys/updBlack")
    public boolean updBlack(TBlackstorage tBlackstorage){
        if (tBlackstorage.getId().equals("-1")){
            return itBlackstorageService.saveBlack(tBlackstorage);
        }else {
            return itBlackstorageService.updBlack(tBlackstorage);
        }
    }
}
