package com.tst.fanzhapian.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

/**
 * <p>
 * 内容类型表
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@Data

public class TMessagetype implements Serializable {

    /**
     * 内容类型编号
     */
    private String id;

    /**
     * 类型名称
     */
    private String name;


}
