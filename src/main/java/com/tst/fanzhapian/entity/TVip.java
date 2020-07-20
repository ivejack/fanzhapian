package com.tst.fanzhapian.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

/**
 * <p>
 * 会员表
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@Data
public class TVip implements Serializable {

    /**
     * vip编号
     */
    private String id;

    /**
     * 用户编号
     */
    private TUser userid;

    /**
     * 积分
     */
    private String score;


}
