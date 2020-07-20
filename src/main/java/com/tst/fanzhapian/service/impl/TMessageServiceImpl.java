package com.tst.fanzhapian.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tst.fanzhapian.entity.TMessage;
import com.tst.fanzhapian.mapper.TMessageMapper;
import com.tst.fanzhapian.service.ITMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 内容表 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@Service
@Transactional
public class TMessageServiceImpl extends ServiceImpl<TMessageMapper, TMessage> implements ITMessageService {

    @Autowired
    private TMessageMapper tMessageMapper;
    /**
     * 查询消息，分页，模糊，全部
     * @param typeid
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<TMessage> getTMessageBylikeAndPage(String typeid, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<TMessage> tMessageBylikeAndPage = tMessageMapper.getTMessageBylikeAndPage(typeid);
        return new PageInfo<TMessage>(tMessageBylikeAndPage);
    }

    /**
     * 查询单个消息
     * @param id
     * @return
     */
    @Override
    public TMessage getOneMessage(String id) {
        return tMessageMapper.getOneMessage(id);
    }
}
