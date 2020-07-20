package com.tst.fanzhapian.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

/**
 * <p>
 * 角色模板表
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@Data

public class TRoleModul implements Serializable {

    /**
     * 角色编号
     */
    private String roleid;

    /**
     * 模板编号
     */
    private String modulid;


}
