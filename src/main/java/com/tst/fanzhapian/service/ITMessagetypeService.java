package com.tst.fanzhapian.service;

import com.tst.fanzhapian.entity.TMessage;
import com.tst.fanzhapian.entity.TMessagetype;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 内容类型表 服务类
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
public interface ITMessagetypeService extends IService<TMessagetype> {

    /** 查询全部 */
    List<TMessagetype> getAllMessage();
}
