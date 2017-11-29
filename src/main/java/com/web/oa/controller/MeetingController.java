package com.web.oa.controller;

import com.web.oa.bean.MeetingRoom;
import com.web.oa.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("meeting")
public class MeetingController {
    @Autowired
    private MeetingService meetingService;
    @RequestMapping("getMeetingRoomManage")
    public String getMeetingRoomManage(Model model){
        List<MeetingRoom> roomList=meetingService.getMeetingRoomList(null);
        model.addAttribute("meetingRoomList",roomList);
        return "meeting/meetingRoom";
    }


}
