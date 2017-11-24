package com.web.oa.dao;

import com.web.oa.bean.Menu;

import java.util.List;

public interface MenuDao {
    /**
     * 根据用户查询菜单
     * @param userId
     * @return
     */
    List<Menu> listByUserId(Long userId);

    List<Menu> lisByName(String menuName, long startIndex, int pageSize);

    List<Menu> getMenuListBySuperiorId(Long menuId);
}
