package com.web.oa.service;

import com.web.oa.bean.MeetingRoom;

import java.util.List;

public interface MeetingService {
    List<MeetingRoom> getMeetingRoomList(MeetingRoom meetingRoom);
}
