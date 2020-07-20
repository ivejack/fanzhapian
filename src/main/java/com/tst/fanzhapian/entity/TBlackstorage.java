package com.tst.fanzhapian.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

/**
 * <p>
 * 黑库表
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@Data

public class TBlackstorage implements Serializable {
    /**
     * 主键黑库编号
     */
    private String id;

    /**
     * 黑库嫌疑信息
     */
    private String message;

    /**
     * 黑库类别
     */
    private String typecontent;


}
