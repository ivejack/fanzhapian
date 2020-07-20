package com.tst.fanzhapian.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

/**
 * <p>
 * 审核表 
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@Data
public class TCheck implements Serializable {

    /**
     * 审核编号
     */
    private String id;

    /**
     * 审核人
     */
    private String checkpeople;
    private TUser checkpeoples;

    /**
     * 审核状态
     */
    private Integer statu;

    /**
     * 审核类型
     */
    private Integer type;

    /**
     * 审核结果
     */
    private Integer result;

    /**
     * 审核内容编号
     */
    private String contentid;
    private TEssay contentids;

    /**
     * 发起人
     */
    private String userid;
    private TUser userids;

    /**
     * 审核时间
     */
    private LocalDateTime checktime;


}
