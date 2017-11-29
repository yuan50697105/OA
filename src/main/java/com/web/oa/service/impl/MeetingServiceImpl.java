package com.web.oa.service.impl;

import com.web.oa.bean.MeetingRoom;
import com.web.oa.dao.MeetingRoomDao;
import com.web.oa.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingServiceImpl implements MeetingService {
    @Autowired
    private MeetingRoomDao meetingRoomDao;

    @Override
    public List<MeetingRoom> getMeetingRoomList(MeetingRoom meetingRoom) {
        return meetingRoomDao.getMeetingRoomList(meetingRoom);
    }
}
