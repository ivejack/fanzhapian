package com.tst.fanzhapian.serviceImpl;

import com.tst.fanzhapian.service.ITRoleService;
import com.tst.fanzhapian.service.ITUserRoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRoleTest {
    @Autowired
    private ITUserRoleService itUserRoleService;

    @Test
    void contextLoads() {
        /** 根据角色编号查询角色信息 ok*/
        System.out.println(itUserRoleService.getByUserId("1"));

    }
}
