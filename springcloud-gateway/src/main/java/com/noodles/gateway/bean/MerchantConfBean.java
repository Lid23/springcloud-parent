package com.noodles.gateway.bean;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * @filename YrzMerchantConfBean
 * @description 认证通商户配置表(YRZ_MERCHANT_CONF)
 * @author Eric
 * @date 2019/05/13 10:00
 */
@XmlAccessorType(XmlAccessType.NONE)
public class MerchantConfBean implements Serializable {

	private static final long serialVersionUID = 4619088140430866997L;

	/** 主键ID*/
	private Integer yrzMerchantConfId;

	/** 商户ID*/
	private String merchantId;

	/** 商户Key*/
	private String merchantKey;

	/** 商户名称*/
	private String merchantName;

	/** 机构账号*/
	private String orgId;

	/** 公钥*/
	private String publicKey;

	/** 所属系统*/
	private String sourceSystem;

	/** 状态(1:启用 0:停用)*/
	private String status;

	/** 创建人*/
	private String createdBy;

	/** 创建时间*/
	private Date createdDate;

	/** 修改人*/
	private String updatedBy;

	/** 修改时间*/
	private Date updatedDate;

	/**
	 * 主键ID
	 * @return YRZ_MERCHANT_CONF_ID 主键ID
	 */
	public Integer getYrzMerchantConfId() {
		return yrzMerchantConfId;
	}

	/**
	 * 主键ID
	 * @param yrzMerchantConfId 主键ID
	 */
	public void setYrzMerchantConfId(Integer yrzMerchantConfId) {
		this.yrzMerchantConfId = yrzMerchantConfId;
	}

	/**
	 * 商户ID
	 * @return MERCHANT_ID 商户ID
	 */
	public String getMerchantId() {
		return merchantId;
	}

	/**
	 * 商户ID
	 * @param merchantId 商户ID
	 */
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId == null ? null : merchantId.trim();
	}

	/**
	 * 商户Key
	 * @return MERCHANT_KEY 商户Key
	 */
	public String getMerchantKey() {
		return merchantKey;
	}

	/**
	 * 商户Key
	 * @param merchantKey 商户Key
	 */
	public void setMerchantKey(String merchantKey) {
		this.merchantKey = merchantKey == null ? null : merchantKey.trim();
	}

	/**
	 * 商户名称
	 * @return MERCHANT_NAME 商户名称
	 */
	public String getMerchantName() {
		return merchantName;
	}

	/**
	 * 商户名称
	 * @param merchantName 商户名称
	 */
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName == null ? null : merchantName.trim();
	}

	/**
	 * 机构账号
	 * @return ORG_ID 机构账号
	 */
	public String getOrgId() {
		return orgId;
	}

	/**
	 * 机构账号
	 * @param orgId 机构账号
	 */
	public void setOrgId(String orgId) {
		this.orgId = orgId == null ? null : orgId.trim();
	}

	/**
	 * 公钥
	 * @return PUBLIC_KEY 公钥
	 */
	public String getPublicKey() {
		return publicKey;
	}

	/**
	 * 公钥
	 * @param publicKey 公钥
	 */
	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey == null ? null : publicKey.trim();
	}

	/**
	 * 所属系统
	 * @return SOURCE_SYSTEM 所属系统
	 */
	public String getSourceSystem() {
		return sourceSystem;
	}

	/**
	 * 所属系统
	 * @param sourceSystem 所属系统
	 */
	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem == null ? null : sourceSystem.trim();
	}

	/**
	 * 状态(1:启用 0:停用)
	 * @return STATUS 状态(1:启用 0:停用)
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 状态(1:启用 0:停用)
	 * @param status 状态(1:启用 0:停用)
	 */
	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	/**
	 * 创建人
	 * @return CREATED_BY 创建人
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * 创建人
	 * @param createdBy 创建人
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy == null ? null : createdBy.trim();
	}

	/**
	 * 创建时间
	 * @return CREATED_DATE 创建时间
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * 创建时间
	 * @param createdDate 创建时间
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * 修改人
	 * @return UPDATED_BY 修改人
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * 修改人
	 * @param updatedBy 修改人
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy == null ? null : updatedBy.trim();
	}

	/**
	 * 修改时间
	 * @return UPDATED_DATE 修改时间
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * 修改时间
	 * @param updatedDate 修改时间
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
}