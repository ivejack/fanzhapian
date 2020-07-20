package com.tst.fanzhapian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tst.fanzhapian.entity.TCheck;
import com.tst.fanzhapian.entity.TEssay;
import com.tst.fanzhapian.entity.TVip;
import com.tst.fanzhapian.enums.CheckTypeEnums;
import com.tst.fanzhapian.mapper.TEssayMapper;
import com.tst.fanzhapian.service.ITCheckService;
import com.tst.fanzhapian.service.ITEssayService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tst.fanzhapian.service.ITVipService;
import com.tst.fanzhapian.util.KeyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 文章表  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@Service
@Transactional
public class TEssayServiceImpl extends ServiceImpl<TEssayMapper, TEssay> implements ITEssayService {

    @Autowired
    private TEssayMapper tEssayMapper;
    @Autowired
    private ITVipService itVipService;
    @Autowired
    private ITCheckService itCheckService;

    /**
     * 查询所有文章，模糊，分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<TEssay> getTEssayByLikeAndPage(Integer pageNum,Integer pageSize,String title) {
        PageHelper.startPage(pageNum,pageSize);
        List<TEssay> tEssayByLikeAndPage = tEssayMapper.getTEssayByLikeAndPage(title);
        return new PageInfo<TEssay>(tEssayByLikeAndPage);
    }

    /**
     *
     * 后台
     * @param pageNum
     * @param pageSize
     * @param title
     * @return
     */
    @Override
    public PageInfo<TEssay> getTEssayByLikeAndPageManager(Integer pageNum, Integer pageSize, String title) {
        PageHelper.startPage(pageNum,pageSize);
        List<TEssay> tEssayByLikeAndPage = tEssayMapper.getTEssayByLikeAndPageManager(title);
        return new PageInfo<TEssay>(tEssayByLikeAndPage);
    }

    /***
     * 查看单篇文章详情
     * @param id
     * @return
     */
    @Override
    public TEssay getOneTEssay(String id) {
        return tEssayMapper.getOneTEssay(id);
    }

    /**
     * 修改
     * @param id
     * @param statu
     * @return
     */
    @Override
    public boolean gotoEssay(String id, Integer statu) {
        return tEssayMapper.gotoEssay(id,statu);
    }

    /**
     * 查询文章总数
     * @param userid
     * @return
     */
    @Override
    public Integer getCountEssayByUserid(String userid) {
        return tEssayMapper.getCountEssayByUserid(userid);
    }

    /**
     * 发表文章
     * @param tEssay
     * @return
     */
    @Override
    public boolean saveTEssay(TEssay tEssay) {
        tEssay.setId(KeyUtils.genUniqueKey());
        //判断该用户是不是会员
        TVip userid = itVipService.getOne(new QueryWrapper<TVip>().eq("userid", tEssay.getUserid()));
        if (userid==null){
            //不是会员，不能发表
        }
        this.save(tEssay);
        //上报审核
        TCheck tCheck = new TCheck();
        //将文章id放入
        tCheck.setContentid(tEssay.getId());
        //将作者放入
        tCheck.setUserid(tEssay.getUserid());
        //类型为发表
        tCheck.setType(CheckTypeEnums.CONSCIOU.getCode());

        return itCheckService.saveCheck(tCheck);
    }

    /**
     * 删除文章（注销）
     * @param tEssay
     * @return
     */
    @Override
    public boolean dieTEssay(TEssay tEssay) {
        tEssay.setStatu(0);
        return this.updateById(tEssay);
    }
}
