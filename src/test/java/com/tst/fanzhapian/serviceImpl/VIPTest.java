package com.tst.fanzhapian.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.tst.fanzhapian.entity.TVip;
import com.tst.fanzhapian.mapper.TVipMapper;
import com.tst.fanzhapian.service.ITModulService;
import com.tst.fanzhapian.service.ITVipService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class VIPTest {
    @Autowired
    private ITVipService itVipService;
    @Autowired
    private TVipMapper tVipMapper;

    @Test
    void contextLoads() {
        /** 根据模板编号查询模板信息 ok*/
//      System.out.println(itVipService.getById("2"));
        /** 模糊分页查询  （通过用户名查询）*/
//        PageInfo<TVip> root = itVipService.getVIPByLikeAndPage(1, 3, "root");
//        System.out.println(root.getList());

//        TVip oneVip = tVipMapper.getOneVip("1");
////        System.out.println(oneVip);
        List<TVip> vipByLike = tVipMapper.getVIPByLike("r");
        vipByLike.forEach(System.out::println);
    }
}
