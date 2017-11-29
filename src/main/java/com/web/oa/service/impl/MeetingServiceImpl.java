package com.web.oa.service.impl;

import com.web.oa.bean.MeetingRoom;
import com.web.oa.bean.MeetingRoomAsk;
import com.web.oa.dao.MeetingRoomAskDao;
import com.web.oa.dao.MeetingRoomDao;
import com.web.oa.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingServiceImpl implements MeetingService {
    @Autowired
    private MeetingRoomDao meetingRoomDao;
    @Autowired
    private MeetingRoomAskDao meetingRoomAskDao;
    @Override
    public List<MeetingRoom> getMeetingRoomList(MeetingRoom meetingRoom) {
        return meetingRoomDao.getMeetingRoomList(meetingRoom);
    }

    @Override
    public boolean saveAsk(MeetingRoomAsk meetingRoomAsk) {
        return meetingRoomAskDao.saveAsk(meetingRoomAsk);
    }

    @Override
    public List<MeetingRoomAsk> getMeetingRoomAskLing(MeetingRoomAsk meetingRoomAsk) {
        return meetingRoomAskDao.getAskList(meetingRoomAsk);
    }

    @Override
    public boolean saveRoom(MeetingRoom meetingRoom) {
        return meetingRoomDao.saveMeetingRoom(meetingRoom);
    }

    @Override
    public boolean updateAskStatus(MeetingRoomAsk meetingRoomAsk) {
        return meetingRoomAskDao.updateAsk(meetingRoomAsk);
    }
}
