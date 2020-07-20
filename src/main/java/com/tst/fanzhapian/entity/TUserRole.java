package com.tst.fanzhapian.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@Data

public class TUserRole implements Serializable {


    /**
     * 用户编号
     */
    private String userid;

    /**
     * 角色编号
     */
    private String roleid;


}
