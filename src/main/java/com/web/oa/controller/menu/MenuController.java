package com.web.oa.controller.menu;

import com.web.oa.bean.Menu;
import com.web.oa.commons.PageModel;
import com.web.oa.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;
    public String list(String menuName,Integer page){
        PageModel<Menu> pageModel=menuService.list(menuName,page,5);
        return null;
    }
}
