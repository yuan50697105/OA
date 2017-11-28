package com.web.oa.controller;

import com.sun.xml.internal.ws.resources.HttpserverMessages;
import com.web.oa.bean.Menu;
import com.web.oa.commons.WebCommons;
import com.web.oa.service.MainService;
import com.web.oa.service.MenuService;
import com.web.oa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("main")
public class MainController {
    @Autowired
    private MenuService menuService;
    @Autowired
    private UserService userService;

    /**
     * 进入请求跳转界面（查看js/main/main.js文件，动态控制tab效果）
     * @param url
     * @param model
     * @return
     */
    @RequestMapping("content")
    public String content(String url, Model model){
        model.addAttribute("url",url);
        return "main/content";
    }
    @RequestMapping("one")
    public String one(Long menuId, HttpSession session,Model model){
        Menu menu=menuService.getMenuByMenuId(menuId);
        List<Menu> menuList=menuService.getChildMenuBySuperiorId(menuId);
        if(null!=menuList){
            Menu m=menuList.get(0);
            String url=session.getServletContext().getContextPath()+"/"+m.getUrl()+m.getParameter();
            model.addAttribute("url",url);
        }else {
            model.addAttribute("url","");
        }
        model.addAttribute(WebCommons.MENU_LIST,menuList);
        model.addAttribute("menu",menu);
        return "main/one";
    }
    @RequestMapping("oneLeft")
    public String oneLeft(Long menuId, HttpSession session,Model model){
        Menu menu=menuService.getMenuByMenuId(menuId);
        List<Menu> menuList=menuService.getChildMenuBySuperiorId(menuId);;
        model.addAttribute(WebCommons.MENU_LIST,menuList);
        model.addAttribute("menu",menu);
        return "main/one_left";
    }

}
