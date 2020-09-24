package com.noodles.springcloudtestprovider.springbootmybatis.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 文件名：DepartMents.java
 * 描述：
 * 作者：KJ00019
 * 日期：2018年11月20日下午4:03:48
 */
@Entity
@Table(name = "departments")
public class DepartMents implements Serializable {

	private static final long serialVersionUID = 1L;

	/**商户号 */
	@Id
	@Column(name = "dept_no")
	private String deptNo;

	/**商户说明 */
	@Column(name = "dept_name")
	private String deptName;

	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
}
