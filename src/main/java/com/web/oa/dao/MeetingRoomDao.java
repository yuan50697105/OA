package com.web.oa.dao;

import com.web.oa.bean.MeetingRoom;

import java.util.List;

public interface MeetingRoomDao {
    boolean saveMeetingRoom(MeetingRoom meetingRoom);

    boolean deleteMeetingRoom(Long meetingRoomId);

    boolean updateMeetingRoom(MeetingRoom meetingRoom);

    MeetingRoom getMeetingRoomByRoomId(Long roomId);

    List<MeetingRoom> getMeetingRoomList(MeetingRoom meetingRoom);

}
