package com.ut.scf.reqbean.project;


import org.hibernate.validator.constraints.NotBlank;

import com.ut.scf.reqbean.BaseReqBean;

public class FinanceInfoDeleteReqBean extends BaseReqBean{
	
	/**
	 * 融资Id
	 */
	@NotBlank(message = "{notblank}")
	private String financeId;

	public String getFinanceId() {
		return financeId;
	}

	public void setFinanceId(String financeId) {
		this.financeId = financeId;
	}
	

}
