package com.ut.scf.reqbean.pub;

import com.ut.scf.reqbean.PageReqBean;

public class ProcessListReqBean  extends PageReqBean{
	/**
	 * 是否分页，0：否，1：是，默认为1.
	 */
	private Integer isPage = 1;

	public Integer getIsPage() {
		return isPage;
	}

	public void setIsPage(Integer isPage) {
		this.isPage = isPage;
	}
	
}
