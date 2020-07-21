package com.tst.fanzhapian;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tst.fanzhapian.entity.TTest;
import com.tst.fanzhapian.entity.TTeststorage;
import com.tst.fanzhapian.entity.TUser;
import com.tst.fanzhapian.service.ITTeststorageService;
import com.tst.fanzhapian.service.ITUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class FanzhapianApplicationTests {

    @Autowired
    private ITTeststorageService itTeststorageService;



    @Test
    void contextLoads() {
        TTeststorage tTeststorage =new TTeststorage();

//        for (int i=1;i<120;i++){
//            tTeststorage.setQuestion("陌生电话转账，可信吗"+i);
//            if (i%2==0){
//                tTeststorage.setAnswer("对");
//            }else {
//                tTeststorage.setAnswer("错");
//            }
//            tTeststorage.setAnalysis("这是假的"+i);
//            itTeststorageService.saveTestStorage(tTeststorage);
//        }
//        itTeststorageService.getTestStorageAll(1,"11").getRecords().forEach(System.out::println);
//        for (int i=0;i<100;i++){
//            HashSet<Integer> set = new HashSet<>();
//            int n =10;
//            HashSet<Integer> ids = getIds(n, set);
//
//            System.out.println(set.size());
//        }

        //获取年龄
        String s1 = "2001-11-11";
        int age = getAge(s1);
        System.out.println(age);
    }

    private int getAge(String birthday){
        String[] split = birthday.split("-");
        int i = Calendar.getInstance().get(Calendar.YEAR) - new Integer(split[0]);
        return i;
    }

    private HashSet<Integer> getIds(Integer n ,HashSet<Integer> set){
        for (int i=0;i<n;i++){
            int random = (int)(Math.random()*100);
            set.add(random);

        }
        if (set.size()<n){
            getIds(n-set.size(),set);
        }

        return set;
    }

}
