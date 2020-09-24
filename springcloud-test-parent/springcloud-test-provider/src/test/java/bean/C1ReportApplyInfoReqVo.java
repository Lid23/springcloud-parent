package bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

/**
 * 文件名：C1ReportApplyInfoReqVo.java
 * 描述：
 * 作者：KJ00019
 * 日期：2018年11月20日下午4:03:51
 */
@Entity
@Table(name = "BHCREDIT_C1REPORT_APPLYINFO")
public class C1ReportApplyInfoReqVo extends AbstractBaihangReportReqVo implements Serializable {

	private static final long serialVersionUID = 4453853851471434162L;

	/**id */
	@Id
	@Column(name = "C1_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "c1SeqGenerator")
	@SequenceGenerator(name = "c1SeqGenerator", sequenceName = "BAIHANG_CREDIT_C1_SEQUENCE")
	private String c1Id;

	/**姓名 */
	@Column(name = "NAME")
	@NotNull(message = "姓名不能为空")
	@Length(min = 2, max = 30, message = "姓名长度不正确")
	private String name;

	/**身份证号 */
	@Column(name = "PID")
	@NotNull(message = "身份证号码不能为空")
	@Pattern(regexp = "(^\\d{15}$)|(^\\d{18}$)|(^\\d{17}(\\d|X|x)$)", message = "身份证格式不正确")
	private String pid;

	/** 手机号*/
	@Column(name = "MOBILE")
	@NotNull(message = "手机号不能为空")
	@Length(min = 11, max = 11, message = "手机号长度不正确")
	private String mobile;

	/** 查询原因*/
	@Column(name = "QUERY_REASON")
	@NotNull(message = "查询原因不能为空")
	@Pattern(regexp = "[1-4]", message = "查询原因不正确")
	private String queryReason;

	/** 担保类型*/
	@Column(name = "GUARANTEE_TYPE")
	private String guaranteeType;

	/** 贷款用途*/
	@Column(name = "LOAN_PURPOSE")
	private String loanPurpose;

	/** 客户类型*/
	@Column(name = "CUSTOMER_TYPE")
	@Pattern(regexp = "[1-4]|99", message = "客户类型不正确")
	private String customType;

	/** 报告编号*/
	@Column(name = "REPORT_ID")
	private String reportId;

	/**申请金额 */
	@Column(name = "APPLY_AMOUNT")
	private String applyAmount;

	/** 贷款编号*/
	@Column(name = "LOAN_ID")
	@NotNull(message = "贷款、授信账户不能为空")
	@Length(min = 1, max = 36, message = "贷款、授信账户账号格式不正确")
	private String loanId;

	/** 家庭地址*/
	@Column(name = "HOME_ADDRESS")
	private String homeAddress;

	/** 家庭电话*/
	@Column(name = "HOME_PHONE")
	private String homePhone;

	/** 工作单位名称*/
	@Column(name = "WORK_NAME")
	private String workName;

	/** 工作单位地址*/
	@Column(name = "WORK_ADDRESS")
	private String workAddress;

	/** 工作单位电话*/
	@Column(name = "WORK_PHONE")
	private String workPhone;

	/** 设备信息*/
	@Column(name = "DEVICE_JSON")
	private String deviceJson;

	public String getC1Id() {
		return c1Id;
	}

	public void setC1Id(String c1Id) {
		this.c1Id = c1Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getQueryReason() {
		return queryReason;
	}

	public void setQueryReason(String queryReason) {
		this.queryReason = queryReason;
	}

	public String getGuaranteeType() {
		return guaranteeType;
	}

	public void setGuaranteeType(String guaranteeType) {
		this.guaranteeType = guaranteeType;
	}

	public String getLoanPurpose() {
		return loanPurpose;
	}

	public void setLoanPurpose(String loanPurpose) {
		this.loanPurpose = loanPurpose;
	}

	public String getCustomType() {
		return customType;
	}

	public void setCustomType(String customType) {
		this.customType = customType;
	}

	public String getReportId() {
		return reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	public String getApplyAmount() {
		return applyAmount;
	}

	public void setApplyAmount(String applyAmount) {
		this.applyAmount = applyAmount;
	}

	public String getLoanId() {
		return loanId;
	}

	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getWorkName() {
		return workName;
	}

	public void setWorkName(String workName) {
		this.workName = workName;
	}

	public String getWorkAddress() {
		return workAddress;
	}

	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public String getDeviceJson() {
		return deviceJson;
	}

	public void setDeviceJson(String deviceJson) {
		this.deviceJson = deviceJson;
	}
}
