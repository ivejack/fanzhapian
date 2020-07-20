package com.tst.fanzhapian.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

/**
 * <p>
 * 内容表
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@Data

public class TMessage implements Serializable {

    /**
     * 内容编号
     */
    private String id;

    /**
     * 内容类型
     */
    private String typeid;

    /**
     * 内容
     */
    private String content;


}
