package com.web.oa.dao;

import com.web.oa.bean.Goods;

import java.util.List;

public interface GoodsDao {
    boolean save(Goods goods);
    boolean delete(Long id);
    boolean update(Goods goods);
    Goods getById(Long id);

    List<Goods> getGoodList();
}
