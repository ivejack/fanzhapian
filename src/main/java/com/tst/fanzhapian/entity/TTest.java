package com.tst.fanzhapian.entity;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

/**
 * <p>
 * 题目表
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@Data

public class TTest implements Serializable {

    /**
     * 题目表编号
     */
    private String id;

    /**
     * 答题人
     */
    private String userid;
    private TUser user;

    /**
     * 得分
     */
    private String grade;


}
