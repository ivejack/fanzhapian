package com.tst.fanzhapian.serviceImpl;


import com.github.pagehelper.PageInfo;
import com.tst.fanzhapian.entity.TEssay;
import com.tst.fanzhapian.entity.TMessage;
import com.tst.fanzhapian.mapper.TEssayMapper;
import com.tst.fanzhapian.mapper.TMessageMapper;
import com.tst.fanzhapian.service.ITEssayService;
import com.tst.fanzhapian.service.ITMessageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MessageTest {
    @Autowired
    private TMessageMapper tMessageMapper;
    @Autowired
    private ITMessageService itMessageService;

    @Test
    void contextLoads() {
//        List<TMessage> tMessageBylikeAndPage = tMessageMapper.getTMessageBylikeAndPage("1");
//        tMessageBylikeAndPage.forEach(System.out::println);
        PageInfo<TMessage> tMessageBylikeAndPage = itMessageService.getTMessageBylikeAndPage(null, 1, 1);
        tMessageBylikeAndPage.getList().forEach(System.out::println);
    }
}
