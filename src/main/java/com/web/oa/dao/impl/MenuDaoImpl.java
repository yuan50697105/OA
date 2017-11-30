package com.web.oa.dao.impl;

import com.web.oa.bean.MeetingRoom;
import com.web.oa.bean.Menu;
import com.web.oa.dao.MenuDao;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class MenuDaoImpl implements MenuDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Override
    public List<Menu> getMainMenuByUserId(Long userId) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        String hql="select m from Menu m where m.menuId in (" +
                "select i.menuId from Impower i where i.roleId in (" +
                "select r.roleId from Role r where r.roleId in (" +
                "select dm.roleId from DepartmentMembers dm where dm.userId=:userId)))" +
                "and m.status='1' and m.superiorId=0";
        Query<Menu> query=session.createQuery(hql, Menu.class);
        query.setParameter("userId",userId);
        return query.list();
    }

    @Override
    public Menu getMenuById(Long menuId) {
        return hibernateTemplate.get(Menu.class,menuId);
    }

    @Override
    public List<Menu> getMenuListBySuperiorId(Long menuId) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        String hql="select m from Menu m where m.superiorId=:menuId";
        Query<Menu> query=session.createQuery(hql,Menu.class);
        query.setParameter("menuId",menuId);
        return query.list();
    }


}
