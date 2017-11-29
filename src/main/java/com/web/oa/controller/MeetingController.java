package com.web.oa.controller;

import com.web.oa.bean.MeetingRoom;
import com.web.oa.bean.MeetingRoomAsk;
import com.web.oa.bean.User;
import com.web.oa.commons.WebCommons;
import com.web.oa.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("meeting")
public class MeetingController {
    @Autowired
    private MeetingService meetingService;

    /**
     * 跳转到会议室管理
     * @param model
     * @return
     */
    @RequestMapping("getMeetingRoomManage")
    public String getMeetingRoomManage(Model model){
        List<MeetingRoom> roomList=meetingService.getMeetingRoomList(null);
        model.addAttribute("meetingRoomList",roomList);
        return "meeting/meetingRoom";
    }

    /**
     * 跳转到申请会议室页面
     * @param model
     * @return
     */
    @RequestMapping("roomAskForm")
    public String roomAskForm(Model model){
        return "meeting/roomAskForm";
    }

    /**
     * ajax获取当前所有的会议室对象
     * @return
     */
    @RequestMapping("ajaxGetMeetingRoomList")
    @ResponseBody
    public List<MeetingRoom> ajaxGetMeetingRoomList(){
        return meetingService.getMeetingRoomList(null);
    }

    /**
     * 申请会议室
     * @param meetingRoomAsk
     * @param session
     * @return
     */
    @RequestMapping("ajaxAddAsk")
    @ResponseBody
    public boolean ajaxAddAsk(MeetingRoomAsk meetingRoomAsk, HttpSession session){
        User user= (User) session.getAttribute(WebCommons.USER);
        meetingRoomAsk.setUserId(user.getUserId());
        meetingRoomAsk.setOperTime(new Date());
        meetingRoomAsk.setStatus("1");
        return meetingService.saveAsk(meetingRoomAsk);
    }

    /**
     * 跳转到会议室申请管理界面
     * @param model
     * @return
     */
    @RequestMapping("getMeetingRoomAskManage")
    public String getMeetingRoomAskManage(Model model){
        List<MeetingRoomAsk> askList=meetingService.getMeetingRoomAskLing(null);
        model.addAttribute("askList",askList);
        return "meeting/roomAskManage";
    }

    /**
     * 跳转到会议室申请记录页面
     * @param model
     * @return
     */
    @RequestMapping("getRoomAskAlready")
    public String getRoomAskAlready(Model model){
        List<MeetingRoomAsk> askList=meetingService.getMeetingRoomAskLing(null);
        model.addAttribute("askList",askList);
        return "meeting/roomAskAlready";
    }

    /**
     * 跳转到新增会议室
     * @return
     */
    @RequestMapping("toAdd")
    public String toAdd(){
        return "meeting/addMeetingRoom";
    }

    /**
     * 新增会议室
     * @param meetingRoom
     * @param session
     * @return
     */
    @RequestMapping("ajaxAdd")
    @ResponseBody
    public boolean ajaxAdd(MeetingRoom meetingRoom,HttpSession session){
        return meetingService.saveRoom(meetingRoom);
    }

    /**
     * 审批会议室申请
     * @param type
     * @param askId
     * @return
     */
    public boolean ajaxUpdateAskStatus(String type,Long askId){
        MeetingRoomAsk meetingRoomAsk=new MeetingRoomAsk();
        //1：待审 2：已通过 3：已完结 4:未通过
        meetingRoomAsk.setStatus(type);
        meetingRoomAsk.setAskId(askId);
        return meetingService.updateAskStatus(meetingRoomAsk);
    }
}
