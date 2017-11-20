package com.web.oa.bean;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE,region = "myCache")
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long goodsId;
    private Long orgId;
    private String goodsName;// 物品名称
    private Double price;// 物品价格
    private String units;// 单位
    private String status;// 状况
    private String introduce;// 描述
    private String remark;// 备注
    private Date purchasingDate;// 购买日期
}
