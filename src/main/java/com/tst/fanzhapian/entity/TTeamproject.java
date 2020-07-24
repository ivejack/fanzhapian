package com.tst.fanzhapian.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 团队项目表
 * </p>
 *
 * @author jobob
 * @since 2020-07-21
 */
@Data
public class TTeamproject implements Serializable{

    /**
     * 团队编号
     */
    private String teamid;
    private TTeam team;

    /**
     * 项目编号
     */
    private String projectid;
    private TProject project;


}
