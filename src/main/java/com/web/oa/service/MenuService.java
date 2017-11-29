package com.web.oa.service;

import com.web.oa.bean.Menu;

import java.util.List;

public interface MenuService {
    Menu getMenuByMenuId(Long menuId);

    List<Menu> getMenuListBySuperiorId(Long menuId);
}
