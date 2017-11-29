package com.web.oa.dao;

import com.web.oa.bean.Menu;

import java.util.List;

public interface MenuDao {
    List<Menu> getMainMenuByUserId(Long userId);


    Menu getMenuById(Long menuId);

    List<Menu> getMenuListBySuperiorId(Long menuId);
}
