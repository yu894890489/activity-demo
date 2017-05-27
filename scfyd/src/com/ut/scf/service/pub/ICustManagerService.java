package com.ut.scf.service.pub;

import java.util.Map;

import org.activiti.engine.impl.util.json.JSONObject;

import com.ut.scf.core.dict.PageInfoBean;
import com.ut.scf.pojo.auto.CorpInfo;
import com.ut.scf.respbean.BaseRespBean;

/**
 * @author jihang
 *	企业
 */
public interface ICustManagerService {
	
	public BaseRespBean getcorpList(Map<String, Object> paramMap, PageInfoBean page);
	
	public BaseRespBean addCorp(CorpInfo corpInfo);
	
	public BaseRespBean updateCorp(CorpInfo corpInfo);
	
	/**
	 * @param jsonObject
	 * 发起流程
	 */
	public void startProcess(JSONObject jsonObject);
	
	/**
	 * 审核的数据
	 * @param jsonObject 需要处理的数据，转换为jsonObject传过来
	 * @return
	 */
	public BaseRespBean doAgree(JSONObject jsonObject);
	
	/**
	 * 流程再申请
	 * @param jsonObject 需要处理的数据，转换为jsonObject传过来
	 * @return
	 */
	public BaseRespBean reApply(JSONObject jsonObject);
	
}