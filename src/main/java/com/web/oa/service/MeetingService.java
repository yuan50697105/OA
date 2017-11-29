package com.web.oa.service;

import com.web.oa.bean.MeetingRoom;
import com.web.oa.bean.MeetingRoomAsk;

import java.util.List;

public interface MeetingService {
    List<MeetingRoom> getMeetingRoomList(MeetingRoom meetingRoom);


    boolean saveAsk(MeetingRoomAsk meetingRoomAsk);

    List<MeetingRoomAsk> getMeetingRoomAskLing(MeetingRoomAsk meetingRoomAsk);

    boolean saveRoom(MeetingRoom meetingRoom);

    boolean updateAskStatus(MeetingRoomAsk meetingRoomAsk);
}
