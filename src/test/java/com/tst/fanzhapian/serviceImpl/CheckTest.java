package com.tst.fanzhapian.serviceImpl;


import com.tst.fanzhapian.entity.TCheck;
import com.tst.fanzhapian.entity.TEssay;
import com.tst.fanzhapian.mapper.TCheckMapper;
import com.tst.fanzhapian.mapper.TEssayMapper;
import com.tst.fanzhapian.service.ITCheckService;
import com.tst.fanzhapian.service.ITEssayService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CheckTest {
    @Autowired
    private TCheckMapper tCheckMapper;
    @Autowired
    private ITCheckService itCheckService;

    @Test
    void contextLoads() {
//        List<TCheck> tCheckByLikeAndPage = tCheckMapper.getTCheckByLikeAndPage(1,1);
//        tCheckByLikeAndPage.forEach(System.out::println);

        try {
            tCheckMapper.toCheck("1594870227426752492","1",2);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
