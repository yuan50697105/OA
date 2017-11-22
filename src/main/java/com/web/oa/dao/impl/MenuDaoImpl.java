package com.web.oa.dao.impl;

import com.sun.org.apache.regexp.internal.RE;
import com.web.oa.bean.DepartmentMembers;
import com.web.oa.bean.Impower;
import com.web.oa.bean.Menu;
import com.web.oa.dao.MenuDao;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class MenuDaoImpl implements MenuDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;


    public List<Menu> listByUserId1(Long userId) {
        String hql = "select m from Menu m where m.menuId in(select i.menuId from Impower i where i.roleId in(select dm.roleId from DepartmentMembers dm where dm.userId =:userid))";
        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        Query<Menu> query = session.createQuery(hql, Menu.class);
        query.setParameter("userid", userId);
        return query.list();
    }
    public List<Menu> listByUserId2(Long userId){
       DetachedCriteria department=DetachedCriteria.forClass(DepartmentMembers.class);
       department.add(Property.forName("userId").eq(userId));
       department.setProjection(Projections.property("roleId"));
       DetachedCriteria impower=DetachedCriteria.forClass(Impower.class);
       impower.add(Property.forName("roleId").in(department));
       impower.setProjection(Projections.property("menuId"));
       DetachedCriteria menu=DetachedCriteria.forClass(Menu.class);
       menu.add(Property.forName("menuId").in(impower));
       return (List<Menu>) hibernateTemplate.findByCriteria(menu);
    }
    @Override
    public List<Menu> listByUserId(Long userId) {
        return listByUserId2(userId);
    }
}
