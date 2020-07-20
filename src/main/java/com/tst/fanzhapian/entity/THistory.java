package com.tst.fanzhapian.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

/**
 * <p>
 * 浏览记录表
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@Data

public class THistory implements Serializable {

    /**
     * 浏览记录编号
     */
    private String id;

    /**
     * 浏览文章编号
     */
    private String essayid;
    private TEssay essay;

    /**
     * 浏览人编号
     */
    private String userid;
    private TUser user;

    /**
     * 浏览状态
     */
    private Integer statu;

    /**
     * 浏览时间
     */
    private LocalDateTime starttime;


}
