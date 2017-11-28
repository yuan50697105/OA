package com.web.oa.bean;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * 物品类
 * 
 * @author Administrator
 */
@Entity
@Table(name = "t_goods")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE,region="myCache")
@DynamicUpdate(value = true)
@DynamicInsert(value = true)
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

	
	
	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", orgId=" + orgId
				+ ", goodsName=" + goodsName + ", price=" + price + ", units="
				+ units + ", status=" + status + ", introduce=" + introduce
				+ ", remark=" + remark + ", purchasingDate=" + purchasingDate
				+ "]";
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getPurchasingDate() {
		return purchasingDate;
	}

	public void setPurchasingDate(Date purchasingDate) {
		this.purchasingDate = purchasingDate;
	}
}
