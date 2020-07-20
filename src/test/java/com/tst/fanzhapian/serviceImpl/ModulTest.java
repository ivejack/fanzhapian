package com.tst.fanzhapian.serviceImpl;

import com.tst.fanzhapian.service.ITModulService;
import com.tst.fanzhapian.service.ITRoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ModulTest {
    @Autowired
    private ITModulService itModulService;

    @Test
    void contextLoads() {
        /** 根据模板编号查询模板信息 ok*/
        System.out.println(itModulService.getByModulID("1"));

    }
}
