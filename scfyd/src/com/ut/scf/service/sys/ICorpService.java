package com.ut.scf.service.sys;

import java.util.List;
import java.util.Map;

import com.ut.scf.reqbean.sys.CorpAddReqBean;
import com.ut.scf.reqbean.sys.CorpDeleteReqBean;
import com.ut.scf.reqbean.sys.CorpListReqBean;
import com.ut.scf.reqbean.sys.CorpUpdateReqBean;
import com.ut.scf.respbean.BaseRespBean;

public interface ICorpService {

	public BaseRespBean corpList(CorpListReqBean reqBean);
	
	public BaseRespBean addCorpInfo(CorpAddReqBean corpAddReqBean);

	public BaseRespBean updateCorp(CorpUpdateReqBean reqBean);

	public BaseRespBean deleteCorp(CorpDeleteReqBean reqBean);
	
	public List<Map<String, String>> getAllRelaCorp();

}
