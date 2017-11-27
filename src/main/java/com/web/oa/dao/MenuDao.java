package com.web.oa.dao;

import com.web.oa.bean.Menu;

import java.util.List;

public interface MenuDao {
    boolean save(Menu menu);

    boolean delete(Long menuId);

    boolean update(Menu menu);

    Menu getByMenuId(Long menuId);

    List<Menu> listMainMenuByUserId(Long userId);

    List<Menu> listChildMenuByMainMenuId(Long menuId);

    List<Menu> listByMeneName(String menuName);
}
