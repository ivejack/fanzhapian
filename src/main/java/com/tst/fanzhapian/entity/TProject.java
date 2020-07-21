package com.tst.fanzhapian.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 项目表
 * </p>
 *
 * @author jobob
 * @since 2020-07-21
 */
@Data
public class TProject{

    /**
     * 项目编号
     */
    private String id;

    /**
     * 项目名
     */
    private String name;


}
