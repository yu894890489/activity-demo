package com.ut.scf.service.project;

import com.ut.scf.reqbean.project.PayCommitmentListReqBean;
import com.ut.scf.respbean.BaseRespBean;

public interface IPayCommitmentService {

	BaseRespBean dealerInfoList();

	BaseRespBean dealerFinanceInfoList(String no);

	BaseRespBean payCommitmentInfoList(PayCommitmentListReqBean reqBean);
}
