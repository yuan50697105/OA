package com.web.oa.dao;

import com.web.oa.bean.MeetingRoom;

import java.util.List;

public interface MeetingRoomDao {
    boolean save(MeetingRoom meetingRoom);
    boolean delete(Long id);
    boolean update(MeetingRoom meetingRoom);
    MeetingRoom getById(Long id);
    List<MeetingRoom> listByName(String name);
}
