package com.web.oa.dao.impl;

import com.web.oa.bean.Goods;
import com.web.oa.dao.GoodsDao;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GoodsDaoImpl implements GoodsDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Goods> getGoodsList() {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        String hql="select g from Goods g";
        Query<Goods> query=session.createQuery(hql,Goods.class);
        return query.list();
    }

    @Override
    public boolean save(Goods goods) {
        try {
            hibernateTemplate.save(goods);
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();;
            return false;
        }
    }
}
