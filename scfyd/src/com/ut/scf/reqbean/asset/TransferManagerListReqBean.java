package com.ut.scf.reqbean.asset;

import com.ut.scf.reqbean.PageReqBean;

public class TransferManagerListReqBean extends PageReqBean{
	/**
	 * 项目名称
	 */
	private String projectName;
	/**
	 * 企业Id
	 */
	private String corpId;
	/**
	 * 合同编号
	 */
	private String contractNo;
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getCorpId() {
		return corpId;
	}
	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	
	
}
