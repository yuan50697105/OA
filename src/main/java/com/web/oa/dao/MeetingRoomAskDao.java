package com.web.oa.dao;

import com.web.oa.bean.MeetingRoomAsk;

public interface MeetingRoomAskDao {
    boolean saveAsk(MeetingRoomAsk meetingRoomAsk);
    boolean deleteAsk(Long id);
    boolean updateAsk(MeetingRoomAsk meetingRoomAsk);
    MeetingRoomAsk getById(Long id);

}
