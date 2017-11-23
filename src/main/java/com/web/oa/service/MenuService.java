package com.web.oa.service;

import com.web.oa.bean.Menu;
import com.web.oa.commons.PageModel;

public interface MenuService {
    PageModel<Menu> list(String menuName, Integer page, int i);
}
