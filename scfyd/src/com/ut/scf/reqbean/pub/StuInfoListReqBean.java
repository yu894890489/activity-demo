package com.ut.scf.reqbean.pub;

import com.ut.scf.reqbean.PageReqBean;


public class StuInfoListReqBean extends PageReqBean{
	
	private String stuName;
	private String mobilePhone;
	private String idNum;
	
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getIdNum() {
		return idNum;
	}
	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}
}
