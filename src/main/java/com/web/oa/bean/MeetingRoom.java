/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.oa.bean;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

/**
 *
 * 会议室持久化类
 * 
 */
@Entity
@Table(name = "t_meetingRoom")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE,region="myCache")
public class MeetingRoom {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long roomId;
	private String roomName;// 会议室名称
	private String status;// 1:空闲中 ，2：使用中，3：保洁中
	private String remark;// 备注

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
