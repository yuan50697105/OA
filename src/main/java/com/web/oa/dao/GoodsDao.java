package com.web.oa.dao;

import com.web.oa.bean.Goods;

import java.util.List;

public interface GoodsDao {
    List<Goods> getGoodsList();

    boolean save(Goods goods);
}
