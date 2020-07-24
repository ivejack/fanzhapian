package com.tst.fanzhapian.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 团队表
 * </p>
 *
 * @author jobob
 * @since 2020-07-21
 */
@Data
public class TTeam implements Serializable{

    /**
     * 团队编号
     */
    private String id;

    /**
     * 队伍名
     */
    private String name;

    /**
     * 创建人
     */
    private String userid;
    private TUser username;

    /**
     * 创建时间
     */
    private LocalDateTime createtime;


}
