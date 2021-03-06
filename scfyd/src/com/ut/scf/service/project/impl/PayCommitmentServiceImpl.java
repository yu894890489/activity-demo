package com.ut.scf.service.project.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ut.scf.core.dict.PageInfoBean;
import com.ut.scf.core.util.BeanUtil;
import com.ut.scf.dao.auto.CorpInfoMapper;
import com.ut.scf.dao.auto.FinanceInfoMapper;
import com.ut.scf.dao.project.IPayCommitmentDao;
import com.ut.scf.pojo.auto.CorpInfo;
import com.ut.scf.pojo.auto.CorpInfoExample;
import com.ut.scf.pojo.auto.CorpInfoExample.Criteria;
import com.ut.scf.pojo.auto.FinanceInfo;
import com.ut.scf.pojo.auto.FinanceInfoExample;
import com.ut.scf.reqbean.project.PayCommitmentListReqBean;
import com.ut.scf.respbean.BaseRespBean;
import com.ut.scf.respbean.ListRespBean;
import com.ut.scf.respbean.PageRespBean;
import com.ut.scf.service.project.IPayCommitmentService;

@Service("payCommitmentService")
public class PayCommitmentServiceImpl implements IPayCommitmentService {
	@Resource
	private CorpInfoMapper corpInfoMapper;
	@Resource
	private FinanceInfoMapper financeInfoMapper;
	@Resource
	private IPayCommitmentDao iPayCommitmentDao;

	// 获取经销商列表
	@Override
	@Transactional(readOnly = true)
	public BaseRespBean dealerInfoList() {
		CorpInfoExample corpInfoExample = new CorpInfoExample();
		Criteria criteria = corpInfoExample.createCriteria();
		criteria.andSysTypeEqualTo((short) 4);// 经销商
		List<CorpInfo> corpInfos = corpInfoMapper
				.selectByExample(corpInfoExample);
		ListRespBean respBean = new ListRespBean();
		respBean.setDataList(corpInfos);
		return respBean;

	}

	// 查询经销商的融资信息

	@Override
	@Transactional(readOnly = true)
	public BaseRespBean dealerFinanceInfoList(String no) {
		FinanceInfoExample example = new FinanceInfoExample();
		com.ut.scf.pojo.auto.FinanceInfoExample.Criteria criteria = example
				.createCriteria();

		criteria.andAgencyNumEqualTo(no);// 经销商

		List<FinanceInfo> infos = financeInfoMapper.selectByExample(example);
		ListRespBean respBean = new ListRespBean();
		respBean.setDataList(infos);
		return respBean;

	}

	// 付款承诺函列表信息

	@Override
	@Transactional
	public BaseRespBean payCommitmentInfoList(PayCommitmentListReqBean reqBean) {
		Map<String, Object> paramMap = BeanUtil.beanToMap(reqBean);
		PageInfoBean page = new PageInfoBean();
		page.setPageNumber(reqBean.getPageNumber());
		page.setPageSize(reqBean.getPageSize());

		List<Map<String, Object>> list = iPayCommitmentDao
				.selectCommitmentList(paramMap, page);

		PageRespBean respBean = new PageRespBean();
		respBean.setDataList(list);
		return respBean;

	}
}
