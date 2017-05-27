package com.ut.scf.service.project;

import java.util.Map;

import com.ut.scf.core.dict.PageInfoBean;
import com.ut.scf.reqbean.project.FinanceInfoUpdateReqBean;
import com.ut.scf.respbean.BaseRespBean;


/**
 * 融资
 * @author Yuancy
 *
 */
public interface IFinanceInfoService {

public BaseRespBean getFinanceInfoList(Map<String, Object> paramMap, PageInfoBean page);
	
	public BaseRespBean insertFinanceInfo(Map<String, Object> paramMap);
	
	public BaseRespBean deleteFinanceInfo(String financeId);
	
	public BaseRespBean updateFinanceInfo(FinanceInfoUpdateReqBean financeInfoUpdateReqBean);
}
