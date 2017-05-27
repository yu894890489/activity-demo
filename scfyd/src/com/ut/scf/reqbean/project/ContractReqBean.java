package com.ut.scf.reqbean.project;

import java.util.Date;

import com.ut.scf.reqbean.PageReqBean;

public class ContractReqBean extends PageReqBean {

	/**
	 * 签约日期
	 */
	private String contractNo;

	private Date signDate;

	/**
	 * 合同生效日期
	 */

	private Date contractValDate;

	/**
	 * 合同到期日期
	 */

	private Date contractDueDate;

	/**
	 * 附件数
	 */
	private byte fileNum;

	/**
	 * 附件信息
	 */
	private String fileInfo;

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public Date getSignDate() {
		return signDate;
	}

	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}

	public Date getContractValDate() {
		return contractValDate;
	}

	public void setContractValDate(Date contractValDate) {
		this.contractValDate = contractValDate;
	}

	public Date getContractDueDate() {
		return contractDueDate;
	}

	public void setContractDueDate(Date contractDueDate) {
		this.contractDueDate = contractDueDate;
	}

	public byte getFileNum() {
		return fileNum;
	}

	public void setFileNum(byte fileNum) {
		this.fileNum = fileNum;
	}

	public String getFileInfo() {
		return fileInfo;
	}

	public void setFileInfo(String fileInfo) {
		this.fileInfo = fileInfo;
	}

}
