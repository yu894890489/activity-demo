package com.ut.scf.service.pub;

import java.util.Map;

import org.activiti.engine.RuntimeService;

import com.ut.scf.core.dict.PageInfoBean;
import com.ut.scf.pojo.auto.LoanInfo;
import com.ut.scf.respbean.BaseRespBean;

public interface ILoanInfoManagerService {
	public BaseRespBean startProcess(RuntimeService runtimeService,String processDefinitionKey);
	
	public BaseRespBean getLoanInfoList(Map<String, Object> paramMap, PageInfoBean page);
	
	public BaseRespBean insertLoanInfo(Map<String, Object> paramMap);
	
	public BaseRespBean updateLoanInfo(LoanInfo loanInfo);
	
	public BaseRespBean deleteLoanInfo(String loanId);
}
