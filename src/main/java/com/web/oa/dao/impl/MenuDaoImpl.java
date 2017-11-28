package com.web.oa.dao.impl;

import com.web.oa.bean.Menu;
import com.web.oa.dao.MenuDao;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
import java.util.List;
import java.util.ResourceBundle;

@Repository
public class MenuDaoImpl implements MenuDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Menu> getMainMenuByUserId(Long userId) {
        String hql="select m from Menu m where m.menuId in (" +
                "select i.menuId from Impower i where i.roleId in (" +
                "select r.roleId from Role r where r.departmentId in (" +
                "select dm.departmentId from DepartmentMembers dm where dm.userId =:userId)))";
        List list=hibernateTemplate.findByNamedParam(hql,"userId",userId);
        if(list.isEmpty()) {
            return null;
        }else {
            return list;
        }
    }

    @Override
    public Menu getMenuByMenuId(Long menuId) {
        return hibernateTemplate.get(Menu.class,menuId);
    }

    @Override
    public List<Menu> getChildMenuBySuperiorId(Long menuId) {
        DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Menu.class);
        detachedCriteria.add(Restrictions.eq("superiorId",menuId));
        detachedCriteria.add(Restrictions.eq("type","2"));
        detachedCriteria.add(Restrictions.eq("status","1"));
        List list=hibernateTemplate.findByCriteria(detachedCriteria);
        if (list.isEmpty()) {
            return null;
        }else {
            return list;
        }
    }
}
