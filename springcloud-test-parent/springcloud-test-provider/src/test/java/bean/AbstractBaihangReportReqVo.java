package bean;

import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

/**
 * @filename AbstractBaihangReportReqVo
 * @description 百行上报抽象类
 * @author 巫威
 * @date 2019/8/6 16:55
 */
public abstract class AbstractBaihangReportReqVo {

	/**商户号 */
	@Column(name = "MER_NO")
	@NotNull(message = "商户号不能为空")
	private String merNo;

	/**业务Id*/
	@Column(name = "BUSINESS_ID")
	@NotNull(message = "业务Id不能为空")
	private String businessId;

	/** 状态*/
	@Column(name = "STATUS")
	private String status;

	/**响应编码*/
	@Column(name = "ERROR_CODE")
	private String errorCode;

	/**响应信息*/
	@Column(name = "ERROR_MESSAGE")
	private String errorMessage;

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

	public String getMerNo() {
		return merNo;
	}

	public void setMerNo(String merNo) {
		this.merNo = merNo;
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
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
}
