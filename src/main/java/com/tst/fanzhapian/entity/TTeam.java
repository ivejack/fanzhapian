package com.tst.fanzhapian.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class TTeam {
    /**
     * 审核编号
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
     * 队员
     */
    private String teamid;
    private List<TUser> teamUser;

    /**
     * 团队项目
     */
    private String project;

    /**
     * 创建时间
     */
    @TableField("createtime")
    private LocalDateTime createtime;
}
