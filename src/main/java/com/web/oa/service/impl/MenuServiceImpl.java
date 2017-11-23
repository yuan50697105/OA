package com.web.oa.service.impl;

import com.web.oa.bean.Menu;
import com.web.oa.commons.PageModel;
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
    public PageModel<Menu> list(String menuName, Integer page, int i) {
        PageModel<Menu> pageModel=new PageModel<>();
        pageModel.setPageIndex(page);
        pageModel.setPageSize(i);
        List<Menu> list=menuDao.lisByName(menuName,pageModel.getStartIndex(),pageModel.getPageSize());
        return pageModel;
    }
}
