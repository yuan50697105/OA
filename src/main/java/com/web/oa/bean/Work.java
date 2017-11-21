package com.web.oa.bean;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "myCache")
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workId;
    private Long orgId;
    private Long userId;
    private String workName;
    private String work;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date planStartDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date planEndDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    private Date startPlanStartDate;
    private Date endPlanEndDate;

    public Long getWorkId() {
        return workId;
    }

    public void setWorkId(Long workId) {
        this.workId = workId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public Date getPlanStartDate() {
        return planStartDate;
    }

    public void setPlanStartDate(Date planStartDate) {
        this.planStartDate = planStartDate;
    }

    public Date getPlanEndDate() {
        return planEndDate;
    }

    public void setPlanEndDate(Date planEndDate) {
        this.planEndDate = planEndDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartPlanStartDate() {
        return startPlanStartDate;
    }

    public void setStartPlanStartDate(Date startPlanStartDate) {
        this.startPlanStartDate = startPlanStartDate;
    }

    public Date getEndPlanEndDate() {
        return endPlanEndDate;
    }

    public void setEndPlanEndDate(Date endPlanEndDate) {
        this.endPlanEndDate = endPlanEndDate;
    }
}
