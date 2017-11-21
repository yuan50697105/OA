package com.web.oa.bean;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "myCache")
public class MeetingRoomAsk {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long askId;
    private Long roomId;// 会议室id
    private Long userId;// 申请用户
    private Date operTime;// 申请时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;// 使用开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;// 使用结束时间
    private String remark;// 备注
    private String status;// 1：待审 2：已通过 3：已完结 4:未通过

    @Transient//使用@Transient 标识的属性将不参与序列化操作（不会到表生成对应的列）
    private String roomName;
    @Transient
    private String userName;

    public Long getAskId() {
        return askId;
    }

    public void setAskId(Long askId) {
        this.askId = askId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getOperTime() {
        return operTime;
    }

    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
