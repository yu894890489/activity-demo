package com.ut.scf.service.pub.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.activiti.engine.RuntimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ut.scf.core.dict.ErrorCodeEnum;
import com.ut.scf.core.dict.PageInfoBean;
import com.ut.scf.core.util.BeanUtil;
import com.ut.scf.core.util.ScfUUID;
import com.ut.scf.dao.auto.LoanInfoMapper;
import com.ut.scf.dao.pub.ILoanInfoDao;
import com.ut.scf.pojo.auto.LoanInfo;
import com.ut.scf.respbean.BaseRespBean;
import com.ut.scf.respbean.PageRespBean;
import com.ut.scf.service.pub.ILoanInfoManagerService;

@Service("loanInfoManagerService")
public class LoanInfoManagerServiceImpl implements ILoanInfoManagerService{
	private static final Logger log = LoggerFactory
			.getLogger(LoanInfoManagerServiceImpl.class);
	
	@Resource
	private ILoanInfoDao loanInfoDao;
	
	@Resource
	private LoanInfoMapper loanInfoMapper;
	
	
	
	@Override
	public BaseRespBean startProcess(RuntimeService runtimeService, String processDefinitionKey) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 条件查询 分页获取
	 * 
	 * @param paramMap
	 * @param page
	 */
	@Override
	@Transactional(readOnly = true)
	public BaseRespBean getLoanInfoList(Map<String, Object> paramMap,PageInfoBean page) {
		
		List<Map<String, Object>> list = loanInfoDao.getLoanInfoList(paramMap, page);
		PageRespBean respBean = new PageRespBean();
		
		log.debug("LoanInfo list : {}", list);
		
		
		respBean.setPages(page.getTotalPage());
		respBean.setRecords(page.getTotalRecord());
		respBean.setDataList(list);
		return respBean;
	}
	

	/**
	 * 新增 
	 * 
	 * @param paramMap
	 * 
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public BaseRespBean insertLoanInfo(Map<String, Object> paramMap) {
		BaseRespBean respBean = new BaseRespBean();
		
		paramMap.put("loanId", ScfUUID.generate());
		
		LoanInfo record = new LoanInfo();
		BeanUtil.mapToBean(paramMap, record);
		int insertNum = loanInfoMapper.insert(record);
		
		log.debug("insert loanInfo num {}", insertNum);
		if (insertNum <= 0) {
			respBean.setResult(ErrorCodeEnum.ADD_FAILED);
			return respBean;
		}

		return respBean;
	}
	
	/**
	 * 删除   
	 * 
	 * @param loanId
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public BaseRespBean deleteLoanInfo(String loanId) {
		BaseRespBean respBean = new BaseRespBean();
		LoanInfo record = new LoanInfo();
		record.setLoanId(loanId);
		int deleteNum = loanInfoMapper.deleteByPrimaryKey(loanId);
		log.debug("delete loanInfo num {}", deleteNum);
		if (deleteNum <= 0) {
			respBean.setResult(ErrorCodeEnum.DELETE_FAILED);
			return respBean;
		}
		return respBean;
	}
	
	/**
	 * 修改   
	 * 
	 * @param loanInfo
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public BaseRespBean updateLoanInfo(LoanInfo loanInfo) {
		BaseRespBean respBean = new BaseRespBean();
		Map<String, Object> paramMap = BeanUtil.beanToMap(loanInfo);
		LoanInfo record = new LoanInfo();
		BeanUtil.mapToBean(paramMap, record);
		int updateNum = loanInfoMapper.updateByPrimaryKeySelective(record);
		log.debug("update im num {}", updateNum);
		if (updateNum <= 0) {
			respBean.setResult(ErrorCodeEnum.UPDATE_FAILED);
			return respBean;
		}
		return respBean;
	}
	
}
