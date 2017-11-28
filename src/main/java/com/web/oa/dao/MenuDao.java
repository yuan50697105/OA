package com.web.oa.dao;

import com.web.oa.bean.Menu;

import java.util.List;

public interface MenuDao {
    List<Menu> getMainMenuByUserId(Long userId);

    Menu getMenuByMenuId(Long menuId);

    List<Menu> getChildMenuBySuperiorId(Long menuId);
}
