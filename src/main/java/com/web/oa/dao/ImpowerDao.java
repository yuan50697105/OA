package com.web.oa.dao;

import com.web.oa.bean.Goods;
import com.web.oa.bean.Impower;

import java.awt.*;

public interface ImpowerDao {
    boolean save(Impower impower);
    boolean delete(Long id);
    boolean update(Impower impower);
    Impower getById(Long id);
}
