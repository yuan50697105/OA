package com.web.oa.dao;

import com.web.oa.bean.Menu;

import java.util.List;

public interface MenuDao {
    List<Menu> listByUserId(Long userId);

    List<Menu> lisByName(String menuName, long startIndex, int pageSize);
}
