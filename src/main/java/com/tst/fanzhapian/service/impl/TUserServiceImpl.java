package com.tst.fanzhapian.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tst.fanzhapian.entity.TUser;
import com.tst.fanzhapian.enums.ResultEnum;
import com.tst.fanzhapian.enums.UserEnums;
import com.tst.fanzhapian.exception.FanzhapianException;
import com.tst.fanzhapian.mapper.TUserMapper;
import com.tst.fanzhapian.service.ITUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tst.fanzhapian.util.KeyUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@Service
@Transactional
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<TUser> listAllUser() {
        return this.list();
    }

    /**
     * 查询单个用户详情
     * @param id
     * @return
     */
    @Override
    public TUser queryOneUser(String id) {
        return this.getById(id);
    }

    /**
     * 模糊，分页，查询所有用户   (根据 用户名，电话，性别，用户状态)
     * @param tUser
     * @return
     */
    @Override
    public IPage<TUser> listUserByLikeAndPage(Integer pageNum, Integer pageSize, TUser tUser) {
        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
        //判断查询用户名是否为空
        if (!(tUser.getUsername()==null)){
            queryWrapper.like("username",tUser.getUsername());
        }
        //判断查询电话是否为空
        if (!(tUser.getPhone()==null)){
            queryWrapper.like("phone",tUser.getPhone());
        }
        //判断查询性别是否为空
        if (!(tUser.getSex()==null)){
            queryWrapper.like("sex",tUser.getSex());
        }
        //判断查询用户状态是否为空
        if (!(tUser.getStatu()==null)){
            queryWrapper.like("statu",tUser.getStatu());
        }
        return this.page(new Page<TUser>(pageNum,pageSize),queryWrapper);
    }

    /**
     * 用户新增
     * @param tUser
     * @return
     */
    @Override
    public boolean saveUser(TUser tUser) {
        //生成主键
        tUser.setId(KeyUtils.genUniqueKey());
        QueryWrapper<TUser> queryWrapper =new QueryWrapper<>();
        queryWrapper.eq("loginname",tUser.getLoginname());
        TUser one = this.getOne(queryWrapper);
        //判断用户名是否被占用
        if (!(one==null)){
            throw new FanzhapianException(ResultEnum.USERNAME_EXIST);
        }
        return this.save(tUser);
    }

    /**
     * 注销用户
     * @param id
     * @return
     */
    @Override
    public boolean dieUser(String id) {
        TUser tUser = queryOneUser(id);
        tUser.setStatu(UserEnums.DIE.getCode());
        return this.updateById(tUser);
    }

    /**
     * 重新授权用户
     * @param id
     * @return
     */
    @Override
    public boolean livingUser(String id) {
        TUser tUser = queryOneUser(id);
        tUser.setStatu(UserEnums.LIVING.getCode());
        return this.updateById(tUser);
    }

    /**
     * 修改用户信息
     * @param tUser
     * @return
     */
    @Override
    public boolean updateUser(TUser tUser) {
        return this.updateById(tUser);
    }

    /**
     * 修改登陆密码
     * @param id
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @Override
    public boolean updateUserPassword(String id,String oldPassword,String newPassword) {
        TUser tUser = queryOneUser(id);
        //判断用户密码是否正确
        if (!oldPassword.equals(tUser.getPassword())){
            throw new FanzhapianException(ResultEnum.LOGINNAME_PASSWORD_ERROR);
        }
        tUser.setPassword(newPassword);
        return updateUser(tUser);
    }

    /**
     * 用户登陆
     * @param loginName
     * @param password
     * @return
     */
    @Override
    public TUser login(String loginName, String password) {
        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
        //判断用户是否存在
        queryWrapper.eq("loginname",loginName);
        TUser checkUser = this.getOne(queryWrapper);
        if (checkUser==null){
            //throw new FanzhapianException(ResultEnum.USER_NOT_EXIST);
            return null;
        }
        //判断用户状态是否注销
        if (checkUser.getStatu()==UserEnums.DIE.getCode()){
            //重新授权登录（修改用户状态为在线）
            livingUser(checkUser.getId());
        }
        //判断用户密码是否正确
        if (!password.equals(checkUser.getPassword())){
            //throw new FanzhapianException(ResultEnum.LOGINNAME_PASSWORD_ERROR);
            return null;
        }
        return checkUser;
    }
}
