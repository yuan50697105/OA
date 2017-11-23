package com.web.oa.service.impl;

import com.web.oa.bean.Goods;
import com.web.oa.dao.GoodsDao;
import com.web.oa.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;
    @Override
    public List<Goods> getGoodsList() {
        return goodsDao.getGoodsList();
    }

    @Override
    public boolean save(Goods goods) {
        return goodsDao.save(goods);
    }
}
