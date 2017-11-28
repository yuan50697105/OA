package com.web.oa.bean;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * 部门类
 * 
 * @author hanfeili
 *
 */
@Entity
@Table(name = "t_department")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE,region="myCache")
@DynamicUpdate(value = true)
@DynamicInsert(value = true)
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long departmentId;// 部门Id
	private Long orgId;// 机构Id
	private Long superiorId;// 上级部门
	private String departmentName;// 部门名称
	private String introduce;// 部门描述
	@Transient
	private String menuIds;


	public String getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(String menuIds) {
		this.menuIds = menuIds;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public Long getSuperiorId() {
		return superiorId;
	}

	public void setSuperiorId(Long superiorId) {
		this.superiorId = superiorId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
}
