package com.tst.fanzhapian.service;

import com.github.pagehelper.PageInfo;
import com.tst.fanzhapian.entity.TMessage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 内容表 服务类
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
public interface ITMessageService extends IService<TMessage> {

    /** 查询消息，分页，模糊，全部 */
    PageInfo<TMessage> getTMessageBylikeAndPage (String typeid,Integer pageNum,Integer pageSize);
    /**  */
    TMessage getOneMessage(String id);
    /** 新增消息 */

}
