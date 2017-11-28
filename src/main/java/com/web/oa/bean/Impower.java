package com.web.oa.bean;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;
/**
 * 权限操作表
 * @author hanfeili
 *
 */
@Entity
@Table(name = "t_impower")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE,region="myCache")
@DynamicInsert(value = true)
@DynamicUpdate(value = true)
public class Impower implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;// 内部id
	private Long orgId;// 机构id
	private Long roleId;// 角色Id
	private Long departmentId;// 部门Id
	private Long menuId;// 菜单id
	private Date inputTime;// 输入时间
	private Long inputUserId;// 填写人Id
	private String inputUserName;// 填写人name
	private Integer rank;// 排序

	public Long getId() {
		return Id;
	}

	public void setId(Long Id) {
		this.Id = Id;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public Date getInputTime() {
		return inputTime;
	}

	public void setInputTime(Date inputTime) {
		this.inputTime = inputTime;
	}

	public Long getInputUserId() {
		return inputUserId;
	}

	public void setInputUserId(Long inputUserId) {
		this.inputUserId = inputUserId;
	}

	public String getInputUserName() {
		return inputUserName;
	}

	public void setInputUserName(String inputUserName) {
		this.inputUserName = inputUserName;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}
}
