package com.tst.fanzhapian.serviceImpl;

import com.tst.fanzhapian.entity.TUser;
import com.tst.fanzhapian.service.ITRoleService;
import com.tst.fanzhapian.service.ITUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RoleTest {
    @Autowired
    private ITRoleService itRoleService;

    @Test
    void contextLoads() {
        /** 根据角色编号查询角色信息 ok*/
        System.out.println(itRoleService.getRole("1"));

    }
}
