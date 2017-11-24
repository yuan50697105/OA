package com.web.oa.service;

import com.web.oa.bean.Menu;

import java.util.List;

public interface MainService {
    List<Menu> getMenuListBySuperiorId(Long menuId);
}
