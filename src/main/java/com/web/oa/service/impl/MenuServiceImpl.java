package com.web.oa.service.impl;

import com.web.oa.bean.Menu;
import com.web.oa.dao.MenuDao;
import com.web.oa.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;


    @Override
    public Menu getMenuByMenuId(Long menuId) {
        return menuDao.getMenuById(menuId);
    }

    @Override
    public List<Menu> getMenuListBySuperiorId(Long menuId) {
        return menuDao.getMenuListBySuperiorId(menuId);
    }
}
