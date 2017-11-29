package com.web.oa.dao.impl;

import com.web.oa.bean.MeetingRoomAsk;
import com.web.oa.dao.MeetingRoomAskDao;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MeetingRoomAskDaoImpl implements MeetingRoomAskDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Override
    public boolean saveAsk(MeetingRoomAsk meetingRoomAsk) {
        try {
            hibernateTemplate.save(meetingRoomAsk);
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteAsk(Long id) {
        try {
            hibernateTemplate.delete(getById(id));
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateAsk(MeetingRoomAsk meetingRoomAsk) {
        try {
            hibernateTemplate.update(meetingRoomAsk);
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public MeetingRoomAsk getById(Long id) {
        return hibernateTemplate.get(MeetingRoomAsk.class,id);
    }

    @Override
    public List getAskList(MeetingRoomAsk meetingRoomAsk) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        String hql="select new MeetingRoomAsk(ask.askId,ask.roomId,ask.userId,ask.operTime,ask.startTime,ask.endTime,ask.status,ask.remark,m.roomName,u.userName) from MeetingRoomAsk ask,MeetingRoom m,User u where ask.roomId = m.roomId and ask.userId = u.userId";
        Query query=session.createQuery(hql);
        return query.list();
    }
}
