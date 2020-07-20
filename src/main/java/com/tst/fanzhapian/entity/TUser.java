package com.tst.fanzhapian.entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@Data
public class TUser implements Serializable {

    /**
     * 用户编号
     */
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 登陆账号
     */
    private String loginname;

    /**
     * 密码
     */
    private String password;

    /**
     * 电话
     */
    private String phone;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 出生日期
     */
    private String birthday;

    /**
     * 用户状态
     */
    private Integer statu;

    /**
     * 创建时间
     */
    @TableField("startTime")
    private LocalDateTime startTime;

    /**
     * 注销时间
     */
    @TableField("endTime")
    private LocalDateTime endTime;





}
