package com.tst.fanzhapian.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@Data

public class TRole implements Serializable {

    /**
     * 角色编号
     */
    private String id;

    /**
     * 角色名称
     */
    private String rolename;


}
