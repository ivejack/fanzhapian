package com.tst.fanzhapian.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

/**
 * <p>
 * 模板表
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@Data

public class TModul implements Serializable {

    /**
     * 模板编号
     */
    private String id;

    /**
     * 模板名称
     */
    private String name;

    /**
     * 模板路径
     */
    private String url;


}
