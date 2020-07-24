package com.tst.fanzhapian.serviceImpl;

import com.tst.fanzhapian.entity.TUser;
import com.tst.fanzhapian.service.ITUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {
    @Autowired
    private ITUserService itUserService;

    @Test
    void contextLoads() {
        TUser tUser = new TUser();
        /** 查询单个用户详情 ok*/
        TUser byId = itUserService.getById("1");
        System.out.println(byId);
//        System.out.println(byId.getAge());

        /** 用户新增 ok*/
//        tUser.setUsername("root1");
//        tUser.setLoginname("root1");
//        tUser.setPassword("root");
//        tUser.setPhone("13575287979");
//        tUser.setSex(1);
//        tUser.setBirthday("2020-12-2");
//        itUserService.saveUser(tUser);

        /** 注销用户 ok*/
//        itUserService.dieUser("1");
        /** 重新授权用户 ok*/
//        itUserService.livingUser("1");
        /** 修改用户信息 ok*/
//        tUser.setId("1");
//        tUser.setPhone("987654321");
//        itUserService.updateUser(tUser);
        /** 修改登陆密码 ok*/
//        itUserService.updateUserPassword("1","admin","root");
        /** 用户登陆 ok*/
//        TUser login = itUserService.login("admin", "admin");
//        System.out.println(login);
        /** 模糊，分页，查询所有用户   (根据 用户名，电话，性别，用户状态)  ok*/
        //tUser.setUsername("root");
        //tUser.setPhone("13575287979");
        //tUser.setSex(1);
        //tUser.setStatu(1);
//        IPage<TUser> tUserIPage = itUserService.listUserByLikeAndPage(1, 2, tUser);
//        for (TUser t : tUserIPage.getRecords()) {
//            System.out.println(t);
//        }
        /** 查询所有用户 ok*/
//        List<TUser> list = itUserService.listAllUser();
//        for (TUser t : list) {
//            System.out.println(t);
//        }

    }
}
