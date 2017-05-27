package com.ut.scf.service.pub.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ut.scf.core.dict.PageInfoBean;
import com.ut.scf.dao.auto.DykRateMapper;
import com.ut.scf.dao.pub.IDykRateDao;
import com.ut.scf.respbean.BaseRespBean;
import com.ut.scf.respbean.PageRespBean;


import com.ut.scf.service.pub.IDykRateService;

@Service("dykRateService")
public class DykRateServiceImpl implements IDykRateService{

	private static final Logger log = LoggerFactory
			.getLogger(DykRateServiceImpl.class);
	
	@Resource
	private IDykRateDao dykRateDao;

	@Resource
	private DykRateMapper dykRateMapper;

	/**
	 * 条件查询 分页获取
	 * 
	 * @param paramMap
	 * @param page
	 */
	@Override
	@Transactional(readOnly = true)
	public BaseRespBean getDykRateList(Map<String, Object> paramMap,PageInfoBean page) {
		
		List<Map<String, Object>> list = dykRateDao.getDykRateList(paramMap, page);
		PageRespBean respBean = new PageRespBean();
		
		log.debug("DykRate list : {}", list);
		
		
		respBean.setPages(page.getTotalPage());
		respBean.setRecords(page.getTotalRecord());
		respBean.setDataList(list);
		return respBean;
	}

	/**
	 * 新增 product
	 * 
	 * @param paramMap
	 * 
	 */
/*	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public BaseRespBean insertInterestManage(Map<String, Object> paramMap) {
		BaseRespBean respBean = new BaseRespBean();
		InterestManagementExample imExample = new InterestManagementExample();
		Criteria criteria = imExample.createCriteria();
		criteria.andProductIdEqualTo((String) paramMap.get("productId"));
		criteria.andBettEqualTo((byte) paramMap.get("bett"));
		criteria.andDeductEqualTo((byte) paramMap.get("deduct"));
		criteria.andReceptionDateEqualTo((String) paramMap.get("receptionDate"));
		criteria.andInterestRateEqualTo((BigDecimal) paramMap.get("interestRate"));
		criteria.andCostRateEqualTo((BigDecimal) paramMap.get("costRate"));
		criteria.andDykInterestRateEqualTo((BigDecimal) paramMap.get("dykInterestRate"));
		criteria.andInterestRateStandardEqualTo((String) paramMap.get("interestRateStandard"));

		// 生成主键Id
		InterestManagement record = new InterestManagement();
		BeanUtil.BeanToBean(paramMap, record);
		record.setRecUid(ScfUUID.generate());
		record.setCreateTime(new Date());
		int insertNum = interestManagementMapper.insert(record);
		
		
		log.debug("insert im num {}", insertNum);
		if (insertNum <= 0) {
			respBean.setResult(ErrorCodeEnum.ADD_FAILED);
			return respBean;
		}

		return respBean;
	}

	*//**
	 * 删除   
	 * 
	 * @param recUid
	 *//*
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public BaseRespBean deleteInterestManage(String recUid) {
		BaseRespBean respBean = new BaseRespBean();
		InterestManagement record = new InterestManagement();
		record.setRecUid(recUid);
		int deleteNum = interestManagementMapper.deleteByPrimaryKey(recUid);
		log.debug("delete im num {}", deleteNum);
		if (deleteNum <= 0) {
			respBean.setResult(ErrorCodeEnum.DELETE_FAILED);
			return respBean;
		}
		return respBean;
	}

	*//**
	 * 修改   
	 * 
	 * @param ImUpdateReqBean
	 *//*
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public BaseRespBean updateInterestManage(ImUpdateReqBean reqBean) {
		BaseRespBean respBean = new BaseRespBean();
		Map<String, Object> paramMap = BeanUtil.beanToMap(reqBean);
		InterestManagement record = new InterestManagement();
		BeanUtil.mapToBean(paramMap, record);
		int updateNum = interestManagementMapper.updateByPrimaryKeySelective(record);
		log.debug("update im num {}", updateNum);
		if (updateNum <= 0) {
			respBean.setResult(ErrorCodeEnum.UPDATE_FAILED);
			return respBean;
		}
		return respBean;
	} */

}
