package com.web.oa.service;

import com.web.oa.bean.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> getGoodsList();

    boolean saveGoods(Goods goods);
}
