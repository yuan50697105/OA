package com.web.oa.dao.impl;

import com.web.oa.bean.MeetingRoom;
import com.web.oa.dao.MeetingRoomDao;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
@Repository
public class MeetingRoomDaoImpl implements MeetingRoomDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Override
    public boolean save(MeetingRoom meetingRoom) {
        try {
            hibernateTemplate.save(meetingRoom);
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
    public boolean update(MeetingRoom meetingRoom) {
        try {
            hibernateTemplate.update(meetingRoom);
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public MeetingRoom getById(Long id) {
        return hibernateTemplate.get(MeetingRoom.class,id);
    }

    @Override
    public List<MeetingRoom> listByName(String name) {
        DetachedCriteria detachedCriteria=DetachedCriteria.forClass(MeetingRoom.class);
        if(!StringUtils.isEmpty(name)){
            detachedCriteria.add(Restrictions.like("roomName",name, MatchMode.ANYWHERE));
        }
        List list=hibernateTemplate.findByCriteria(detachedCriteria);
        if(list.isEmpty()){
            return null;
        }else {
            return list;
        }
    }
}
