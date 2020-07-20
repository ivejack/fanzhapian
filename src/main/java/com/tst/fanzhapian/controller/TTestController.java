package com.tst.fanzhapian.controller;


import com.tst.fanzhapian.entity.TTest;
import com.tst.fanzhapian.entity.TTeststorage;
import com.tst.fanzhapian.service.ITTestService;
import com.tst.fanzhapian.service.ITTeststorageService;
import com.tst.fanzhapian.util.KeyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 * <p>
 * 题目表 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@RestController
public class TTestController{

    @Autowired
    private ITTestService itTestService;
    @Autowired
    private ITTeststorageService itTeststorageService;

    /**
     * 提交试卷
     */
    @RequestMapping("/saveTest")
    public String saveTest(HttpServletRequest request, String[] ids, String ans[]){
        TTest tTest = new TTest();
        Integer grade=0;
        for(int i =0 ;i<ids.length;i++){
            TTeststorage oneTestStorage = itTeststorageService.getOneTestStorage(ids[i], ans[i]);
            if (oneTestStorage!=null){
                grade+=10;
            }else {
                grade+=0;
            }
        }
        tTest.setGrade(grade.toString());
        tTest.setId(KeyUtils.genUniqueKey());
        tTest.setUserid((String)(request.getSession().getAttribute("userid")));
        itTestService.saveTest(tTest);
        return grade.toString();
    }



    /**
     * 抽题
     * @return
     */
    @RequestMapping("/getTestList")
    public List<TTeststorage> getTestList(){
        HashSet<Integer> ids = getIds(10, new HashSet<>());
//        System.out.println(ids);
        List<TTeststorage> tTeststorages = itTeststorageService.listByIds(ids);
        return tTeststorages;
    }
    /**
     * 随机数抽取
     * @param set
     * @return
     */
    private HashSet<Integer> getIds(Integer n ,HashSet<Integer> set){
        Random random =new Random();
        for (int i=0;i<n;i++){
//            int random = (int)(Math.random()*100)+1;
            int i1 = random.nextInt(100)+1;
            set.add(i1);
        }
        if (set.size()<n){
            getIds(n-set.size(),set);
        }
//        System.out.println(set);
        return set;
    }

}