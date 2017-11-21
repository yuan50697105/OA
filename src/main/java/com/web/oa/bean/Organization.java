package com.web.oa.bean;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "myCache")
public class Organization implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orgId;// 机构id
    private String superiorId;// 上级机构id
    private String orgName;// 机构名称
    private String type;// 机构类型
    private String introduction;// 机构介绍
    private String registeredCapital;// 注册资金
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date registerTime;// 注册时间
    private String status;// 状态标志
    private String corporation;// 法人代表
    private String telephone;// 联系电话
    private String zipCode;// 邮政编码
    private String email;// 电子邮箱
    private String address;// 注册地址
    private String businessLicenseNo;// 营业执照号
    private String remark;// 备注
}
