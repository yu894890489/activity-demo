package com.ut.scf.service.pub;

import com.ut.scf.reqbean.pub.StuInfoListReqBean;
import com.ut.scf.respbean.BaseRespBean;

public interface IStuManagerService {
	
	public BaseRespBean getStuInfoList(StuInfoListReqBean stuInfoListReqBean);
}
