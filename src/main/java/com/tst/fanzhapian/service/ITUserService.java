package com.tst.fanzhapian.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tst.fanzhapian.entity.TUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
public interface ITUserService extends IService<TUser> {

    /** 查询所有用户 */
    List<TUser> listAllUser();
    /** 查询单个用户详情 */
    TUser queryOneUser(String id);
    /** 模糊，分页，查询所有用户   (根据 用户名，电话，性别，用户状态)*/
    IPage<TUser> listUserByLikeAndPage(Integer pageNum, Integer pageSize, TUser tUser);
    /** 用户新增 */
    boolean saveUser(TUser tUser);
    /** 注销用户 */
    boolean dieUser(String id);
    /** 重新授权用户 */
    boolean livingUser(String id);
    /** 修改用户信息 */
    boolean updateUser(TUser tUser);
    /** 修改登陆密码 */
    boolean updateUserPassword(String id,String oldPassword,String newPassword);
    /** 用户登陆 */
    TUser login(String loginName,String password);
}
