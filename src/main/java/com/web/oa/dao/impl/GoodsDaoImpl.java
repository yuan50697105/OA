package com.web.oa.dao.impl;

import com.web.oa.bean.Goods;
import com.web.oa.dao.GoodsDao;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GoodsDaoImpl implements GoodsDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Override
    public boolean save(Goods goods) {
        try {
            hibernateTemplate.save(goods);
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {
        try {
            hibernateTemplate.delete(getById(id));
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Goods goods) {
        try {
            hibernateTemplate.update(goods);
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Goods getById(Long id) {
        return hibernateTemplate.get(Goods.class,id);
    }

    @Override
    public List<Goods> getGoodList() {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Goods.class);
        List list = hibernateTemplate.findByCriteria(detachedCriteria);
        if (list.isEmpty()) {
            return null;
        }else {
            return list;
        }
    }
}
