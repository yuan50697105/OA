package com.web.oa.dao.impl;

import com.web.oa.bean.Menu;
import com.web.oa.dao.MenuDao;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
public class MenuDaoImpl implements MenuDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public boolean save(Menu menu) {
        try {
            hibernateTemplate.save(menu);
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Long menuId) {
        try {
            hibernateTemplate.delete(getByMenuId(menuId));
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Menu menu) {
        try {
            hibernateTemplate.update(menu);
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Menu getByMenuId(Long menuId) {
        return hibernateTemplate.get(Menu.class, menuId);
    }

    @Override
    public List<Menu> listMainMenuByUserId(Long userId) {
        String hql = "select m from Menu m where m.menuId in (" +
                "select i.menuId from Impower i where i.roleId in (" +
                "select r.roleId from Role r where r.departmentId in (" +
                "select dm.departmentId from DepartmentMembers dm where dm.userId=:userId)))" +
                "and m.status='1' and m.type='1'";
        List list = hibernateTemplate.findByNamedParam(hql, "userId", userId);
        if (list.isEmpty()) {
            return null;
        } else {
            return list;
        }
    }

    @Override
    public List<Menu> listChildMenuByMainMenuId(Long menuId) {
        String hql = "select m from Menu m where m.superiorId=menuId and m.type='2' and m.status='1'";
        List list = hibernateTemplate.findByNamedParam(hql, "menuId", menuId);
        if (list.isEmpty()) {
            return null;
        } else {
            return list;
        }
    }

    @Override
    public List<Menu> listByMeneName(String menuName) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Menu.class);
        if (!StringUtils.isEmpty(menuName)) {
            detachedCriteria.add(Restrictions.like("menuName", menuName, MatchMode.ANYWHERE));
        }
        List list = hibernateTemplate.findByCriteria(detachedCriteria);
        if (list.isEmpty()) {
            return null;
        } else {
            return list;
        }
    }
}
