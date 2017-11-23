package com.web.oa.controller.role;

import com.web.oa.bean.Role;
import com.web.oa.commons.SQLTip;
import com.web.oa.commons.WebCommons;
import com.web.oa.service.RoleService;
import com.web.oa.commons.PageModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/role")
public class RoleController {
    private RoleService roleService;
    public String list(String name, Integer page, Model model){
        PageModel<Role> pageModel=roleService.list(name,page,5);
        model.addAttribute("page",pageModel);
        return null;
    }
    public String toSave(){
        return null;
    }
    public String save(Role role, RedirectAttributes attributes){
        boolean flag=roleService.save(role);
        attributes.addFlashAttribute(WebCommons.TIP, SQLTip.save(flag));
        return null;
    }
    public String delete(Long id,RedirectAttributes attributes){
        boolean flag=roleService.delete(id);
        attributes.addFlashAttribute(WebCommons.TIP,SQLTip.delete(flag));
        return null;
    }
    public String toUpdate(Long id,Model model){
        Role role=roleService.getById(id);
        model.addAttribute("role",role);
        return null;
    }
    public String update(Role role,RedirectAttributes attributes){
        boolean flag=roleService.update(role);
        attributes.addFlashAttribute(WebCommons.TIP,SQLTip.update(flag));
        return null;
    }
}
