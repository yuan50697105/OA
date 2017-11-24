package com.web.oa.dao.impl;

import com.sun.org.apache.regexp.internal.RE;
import com.web.oa.bean.DepartmentMembers;
import com.web.oa.bean.Impower;
import com.web.oa.bean.Menu;
import com.web.oa.dao.MenuDao;
import org.hibernate.Session;
import org.hibernate.criterion.*;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Member;
import java.text.DecimalFormat;
import java.util.List;
@Repository
public class MenuDaoImpl implements MenuDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;


    @Override
    public List<Menu> listByUserId(Long userId) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        String hql="select m from Menu m where m.menuId in (select i.menuId from Impower i where i.roleId in (select dm.roleId from DepartmentMembers dm where dm.userId=:userid)) and m.grade!='0' and m.status='1' and m.superiorId=0";
        Query<Menu> query=session.createQuery(hql,Menu.class);
        query.setParameter("userid",userId);
        return query.list();
    }

    @Override
    public List<Menu> lisByName(String menuName, long startIndex, int pageSize) {
        return null;
    }

    @Override
    public List<Menu> getMenuListBySuperiorId(Long menuId) {
        DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Menu.class);
        detachedCriteria.add(Restrictions.eq("superiorId",menuId));
        return (List<Menu>) hibernateTemplate.findByCriteria(detachedCriteria);
    }

}
