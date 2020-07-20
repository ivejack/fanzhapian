package com.tst.fanzhapian.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

/**
 * <p>
 * 文章表 
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@Data

public class TEssay implements Serializable {

    /**
     * 文章编号
     */
    private String id;

    /**
     * 发表人
     */
    private TUser user;
    private String userid;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 文章状态
     */
    private Integer statu;

    /**
     * 发表时间
     */
    private LocalDateTime createtime;


}
