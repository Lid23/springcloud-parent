package com.noodles.springboottest.springbootmybatis.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 文件名：BaihangCreditMerConfigBean.java
 * 描述：
 * 作者：KJ00019
 * 日期：2018年11月20日下午4:03:48
 */
@Entity
@Table(name = "BHCREDIT_MER_CONFIG")
public class BaihangCreditMerConfigBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/**商户号 */
	@Id
	@Column(name = "MER_NO")
	private String merNo;

	/**商户说明 */
	@Column(name = "MER_INFO")
	private String merInfo;

	/**状态*/
	@Column(name = "STATUS")
	private String status;

	/** 创建人 */
	@Column(name = "CREATED_BY")
	private String createdBy;

	/** 创建时间 */
	@Column(name = "CREATED_DATE")
	private Date createdDate;

	/** 修改人 */
	@Column(name = "UPDATED_BY")
	private String updatedBy;

	/** 修改时间 */
	@Column(name = "UPDATED_DATE")
	private Date updatedDate;

	/** 机构用户名 */
	@Column(name = "BAIHANG_MER_USER")
	private String baihangMerUser;

	/** 机构密码 */
	@Column(name = "BAIHANG_MER_PWD")
	private String baihangMerPwd;

	/** 机构公钥*/
	@Column(name = "BAIHANG_MER_PUBLIC_KEY")
	private String baihangMerPublicKey;

	/**核验平台客户标识*/
	@Column(name = "BAIHANG_VERIFICATION_SECRETID")
	private String baihangVerificationSecretid;

	/**核验平台密钥*/
	@Column(name = "BAIHANG_VERIFICATION_SECRETKEY")
	private String baihangVerificationSecretKey;

	/**查询有效天数*/
	@Column(name = "VALIDATE_DAYS")
	private Integer validateDays;

	public String getMerNo() {
		return merNo;
	}

	public void setMerNo(String merNo) {
		this.merNo = merNo;
	}

	public String getMerInfo() {
		return merInfo;
	}

	public void setMerInfo(String merInfo) {
		this.merInfo = merInfo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getBaihangMerUser() {
		return baihangMerUser;
	}

	public void setBaihangMerUser(String baihangMerUser) {
		this.baihangMerUser = baihangMerUser;
	}

	public String getBaihangMerPwd() {
		return baihangMerPwd;
	}

	public void setBaihangMerPwd(String baihangMerPwd) {
		this.baihangMerPwd = baihangMerPwd;
	}

	public String getBaihangMerPublicKey() {
		return baihangMerPublicKey;
	}

	public void setBaihangMerPublicKey(String baihangMerPublicKey) {
		this.baihangMerPublicKey = baihangMerPublicKey;
	}

	public String getBaihangVerificationSecretid() {
		return baihangVerificationSecretid;
	}

	public void setBaihangVerificationSecretid(String baihangVerificationSecretid) {
		this.baihangVerificationSecretid = baihangVerificationSecretid;
	}

	public String getBaihangVerificationSecretKey() {
		return baihangVerificationSecretKey;
	}

	public void setBaihangVerificationSecretKey(String baihangVerificationSecretKey) {
		this.baihangVerificationSecretKey = baihangVerificationSecretKey;
	}

	public Integer getValidateDays() {
		return validateDays;
	}

	public void setValidateDays(Integer validateDays) {
		this.validateDays = validateDays;
	}
}
