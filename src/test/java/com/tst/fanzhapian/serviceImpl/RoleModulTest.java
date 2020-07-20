package com.tst.fanzhapian.serviceImpl;

import com.tst.fanzhapian.entity.TModul;
import com.tst.fanzhapian.service.ITModulService;
import com.tst.fanzhapian.service.ITRoleModulService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class RoleModulTest {
    @Autowired
    private ITRoleModulService itRoleModulService;

    @Test
    void contextLoads() {
        /** 根据角色编号查询该角色所有模块 ok*/
        List<TModul> byRoleID = itRoleModulService.getByRoleID("2");
        for (TModul m : byRoleID) {
            System.out.println(m);
        }


    }
}
