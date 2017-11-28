package com.web.oa.bean;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "myCache")
@DynamicInsert(value = true)
@DynamicUpdate(value = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId; //用户Id
    private Long orgId; //机构Id
    private String userName; //帐号
    private String userPassword; //密码
    private Date createTime; //建立时间
    private Date expireTime; //注销时间
    private String mark; //有效标志 1：启用 2：停用
    private String spellCode; // 拼音码
    private String wtu; //五笔码
    private String privateKey;// 私钥
    private String position;// 职位 1：管理员 2：普通用户

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", orgId=" + orgId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", createTime=" + createTime +
                ", expireTime=" + expireTime +
                ", mark='" + mark + '\'' +
                ", spellCode='" + spellCode + '\'' +
                ", wtu='" + wtu + '\'' +
                ", privateKey='" + privateKey + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getSpellCode() {
        return spellCode;
    }

    public void setSpellCode(String spellCode) {
        this.spellCode = spellCode;
    }

    public String getWtu() {
        return wtu;
    }

    public void setWtu(String wtu) {
        this.wtu = wtu;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
