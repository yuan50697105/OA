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
    public boolean saveMeetingRoom(MeetingRoom meetingRoom) {
        try {
            hibernateTemplate.save(meetingRoom);
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteMeetingRoom(Long meetingRoomId) {
        try {
            hibernateTemplate.delete(hibernateTemplate.get(MeetingRoom.class,meetingRoomId));
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateMeetingRoom(MeetingRoom meetingRoom) {
        try {
            hibernateTemplate.update(meetingRoom);
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public MeetingRoom getMeetingRoomByRoomId(Long roomId) {
        return hibernateTemplate.get(MeetingRoom.class,roomId);
    }

    @Override
    public List<MeetingRoom> getMeetingRoomList(MeetingRoom meetingRoom) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(MeetingRoom.class);
        if (null != meetingRoom) {
            if (null != meetingRoom.getRoomId()) {
                detachedCriteria.add(Restrictions.eq("roomId", meetingRoom.getRoomId()));
            }
            if (!StringUtils.isEmpty(meetingRoom.getRoomName())) {
                detachedCriteria.add(Restrictions.like("roomName", meetingRoom.getRoomName(), MatchMode.ANYWHERE));
            }
            if (!StringUtils.isEmpty(meetingRoom.getStatus())) {
                detachedCriteria.add(Restrictions.eq("status", meetingRoom.getStatus()));
            }
        }
        List list = hibernateTemplate.findByCriteria(detachedCriteria);
        if (list.isEmpty()) {
            return null;
        }else {
            return list;
        }
    }

}
