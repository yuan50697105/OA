package com.web.oa.dao.impl;

import com.web.oa.bean.DepartmentMembers;
import com.web.oa.bean.Impower;
import com.web.oa.bean.Menu;
import com.web.oa.dao.MenuDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.awt.image.RescaleOp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Repository
public class MenuDaoImpl implements MenuDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Menu> listByUserId(Long userId) {
        DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Menu.class);
        String hql = "select m from Menu m where m.menuId in(select i.menuId from Impower i where i.roleId in(select dm.roleId from DepartmentMembers dm where dm.userId =:userid))";
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        Query<Menu> query=session.createQuery(hql,Menu.class);
        query.setParameter("userid",userId);
        return query.list();
    }
}
