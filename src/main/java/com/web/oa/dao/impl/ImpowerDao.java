package com.web.oa.dao.impl;

import com.web.oa.bean.Impower;

public interface ImpowerDao {
    boolean save(Impower impower);
    boolean delete(Long id);
    boolean update(Impower impower);
    Impower getById(Long id);
}
