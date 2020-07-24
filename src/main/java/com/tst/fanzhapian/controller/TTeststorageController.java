package com.tst.fanzhapian.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tst.fanzhapian.entity.TTeststorage;
import com.tst.fanzhapian.service.ITTeststorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

/**
 * <p>
 * 题库表 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@RestController
@RequestMapping("/sys")
public class TTeststorageController {

    @Autowired
    private ITTeststorageService itTeststorageService;

    /**
     * 查询全部,分页，模糊
     * @param pageNum 当前页
     * @param question  题目名
     * @return
     */
    @RequestMapping("/getTestStorageAll")
    public IPage<TTeststorage> getTestStorageAll(Integer pageNum,String question){
//        System.out.println("goin");
//        System.out.println("1:"+pageNum);
//        System.out.println("2:"+question);
        return itTeststorageService.getTestStorageAll(pageNum, question);
    }

    /**
     *
     * @param id 题目id
     * @return
     */
    @RequestMapping("/getOneTestStorage")
    public TTeststorage getOneTestStorage(String id){
//        System.out.println("goin");
//        System.out.println("1:"+id);
        return itTeststorageService.getOneTestStorage(id);
    }

    /**
     * 保存或新增
     * @param tTeststorage 题库实体类
     * @return
     */
    @RequestMapping("/saveTestStorage")
    public boolean saveTestStorage(TTeststorage tTeststorage){
//        System.out.println("1:"+tTeststorage);
        if (tTeststorage.getId().equals("-1")){
            //新增
            return itTeststorageService.saveTestStorage(tTeststorage);
        }else {
            return itTeststorageService.updTestStorage(tTeststorage);
        }
    }

    /**
     *
     * @param id 题目id
     * @return
     */
    @RequestMapping("/delTestStorage")
    public boolean delTestStorage(String id){
//        System.out.println("1:"+id);
        return itTeststorageService.delTestStorage(id);
    }


}
