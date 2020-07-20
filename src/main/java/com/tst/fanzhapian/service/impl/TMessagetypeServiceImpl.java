package com.tst.fanzhapian.service.impl;

import com.tst.fanzhapian.entity.TMessage;
import com.tst.fanzhapian.entity.TMessagetype;
import com.tst.fanzhapian.mapper.TMessagetypeMapper;
import com.tst.fanzhapian.service.ITMessagetypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 内容类型表 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@Service
@Transactional
public class TMessagetypeServiceImpl extends ServiceImpl<TMessagetypeMapper, TMessagetype> implements ITMessagetypeService {

    /**
     * 查询全部
     * @return
     */
    @Override
    public List<TMessagetype> getAllMessage() {
        return this.list();
    }
}
