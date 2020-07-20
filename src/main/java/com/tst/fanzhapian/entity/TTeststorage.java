package com.tst.fanzhapian.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

/**
 * <p>
 * 题库表
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@Data

public class TTeststorage implements Serializable {

    /**
     * 题库编号
     */
    private String id;

    /**
     * 题目
     */
    private String question;

    /**
     * 答案
     */
    private String answer;

    /**
     * 解析
     */
    private String analysis;


}
