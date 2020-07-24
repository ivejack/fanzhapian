package com.tst.fanzhapian.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 团员表
 * </p>
 *
 * @author jobob
 * @since 2020-07-21
 */
@Data
public class TTeampeople implements Serializable {

    /**
     * 团队编号
     */
    private String id;
    private TTeam team;

    /**
     * 成员
     */
    private String userid;
    private TUser user;


}
