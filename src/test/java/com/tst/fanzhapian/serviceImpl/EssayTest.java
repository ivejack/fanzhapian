package com.tst.fanzhapian.serviceImpl;


import com.github.pagehelper.PageInfo;
import com.tst.fanzhapian.entity.TEssay;
import com.tst.fanzhapian.entity.TUser;
import com.tst.fanzhapian.mapper.TEssayMapper;
import com.tst.fanzhapian.service.ITEssayService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class EssayTest {
    @Autowired
    private TEssayMapper tEssayMapper;
    @Autowired
    private ITEssayService itEssayService;

    @Test
    void contextLoads() {
        TEssay tEssay = new TEssay();
        List<TEssay> tEssayByLikeAndPage = tEssayMapper.getTEssayByLikeAndPage("骗");
        tEssayByLikeAndPage.forEach(System.out::println);

//        PageInfo<TEssay> tEssayByLikeAndPage = itEssayService.getTEssayByLikeAndPage(1, 2);
//        tEssayByLikeAndPage.getList().forEach(System.out::println);

//        TEssay oneTEssay = tEssayMapper.getOneTEssay("1");
//        System.out.println(oneTEssay);

//        tEssay.setId("1");
//        itEssayService.dieTEssay(tEssay);

//        for (int i=1;i<30;i++){
//            tEssay.setUserid("1");
//            tEssay.setContent("42425212");
//            tEssay.setTitle("afdf");
//            itEssayService.saveTEssay(tEssay);
//        }
        Integer countEssayByUserid = tEssayMapper.getCountEssayByUserid("0");
        System.out.println(countEssayByUserid);
    }
}
