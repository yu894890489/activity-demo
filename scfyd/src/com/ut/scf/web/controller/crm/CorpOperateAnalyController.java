package com.ut.scf.web.controller.crm;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ut.scf.core.dict.ErrorCodeEnum;
import com.ut.scf.core.dict.PageInfoBean;
import com.ut.scf.core.dict.ScfBizConsts;
import com.ut.scf.core.dict.ScfCacheDict;
import com.ut.scf.core.dict.ScfConsts;
import com.ut.scf.core.util.BeanUtil;
import com.ut.scf.core.util.ScfBizUtil;
import com.ut.scf.reqbean.RecUidReqBean;
import com.ut.scf.reqbean.crm.CorpOperateAnalyAddReqBean;
import com.ut.scf.reqbean.crm.CorpOperateAnalyListReqBean;
import com.ut.scf.reqbean.crm.CorpOperateAnalyUpdateReqBean;
import com.ut.scf.respbean.BaseRespBean;
import com.ut.scf.service.crm.ICorpOperateAnalyService;
import com.ut.scf.web.controller.BaseJsonController;

/**
 * 企业经营情况分析相关的控制类
 * 
 * @author sunll
 *
 */
@Controller
public class CorpOperateAnalyController extends BaseJsonController {

	private static final Logger log = LoggerFactory
			.getLogger(CorpOperateAnalyController.class);

	@Resource
	private ICorpOperateAnalyService corpOperateAnalyService;

	@RequestMapping(value = "/corpOperateAnaly/list", method = RequestMethod.POST, consumes = { "application/json" }, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody BaseRespBean corpOperateAnalyList(
			HttpSession httpSession,
			@RequestBody CorpOperateAnalyListReqBean reqBean)
			throws IOException {
		Map<String, Object> paramMap = BeanUtil.beanToMap(reqBean);
		
		// 获取用户信息
		String corpIdSession = (String) httpSession
				.getAttribute(ScfConsts.SESSION_CORP_ID);
		log.debug("corpIdSession: {}", corpIdSession);
		String userIdSession = (String) httpSession
				.getAttribute(ScfConsts.SESSION_USER_ID);
		log.debug("userIdSession: {}", userIdSession);
		String roleIdSession = (String) httpSession
				.getAttribute(ScfConsts.SESSION_ROLE_ID);
		log.debug("roleIdSession: {}", roleIdSession);
		int roleTypeSession = (int) httpSession
				.getAttribute(ScfConsts.SESSION_ROLE_TYPE);
		log.debug("roleTypeSession: {}", roleTypeSession);
		
		// 保理商类型只能查看自己的客户企业数据，平台类型不限制，其他类型只能查看自己企业数据
		// 保理商类型下，保理商管理员可以查看所有数据，其他角色只能查看自己的业务数据
		if (roleTypeSession == ScfBizConsts.ROLE_TYPE_FACTOR) {
			paramMap.put("relaCorpId", corpIdSession);
//			if (!roleIdSession.equals(ScfBizConsts.ROLE_ID_FACTOR_ADMIN)) {
//				paramMap.put("createUserId", userIdSession);
//			}
			List<String> userCorpList = ScfCacheDict.userCorpMap.get(userIdSession);
			String userCorpStr = ScfBizUtil.listToSQLStr(userCorpList);
			paramMap.put("userCorpList", userCorpStr);
		} else if (roleTypeSession != ScfBizConsts.ROLE_TYPE_PLAT) {
			paramMap.put("corpId", corpIdSession);
		}
		
		PageInfoBean page = new PageInfoBean();
		page.setPageNumber(reqBean.getPageNumber());
		page.setPageSize(reqBean.getPageSize());
		return corpOperateAnalyService.getCorpOperateAnalyList(paramMap, page);
	}

	@RequestMapping(value = "/corpOperateAnaly/add", method = RequestMethod.POST, consumes = { "application/json" }, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody BaseRespBean corpOperateAnalyAdd(
			HttpSession httpSession,
			@Valid @RequestBody CorpOperateAnalyAddReqBean reqBean,
			BindingResult bindingResult) throws IOException {
		BaseRespBean respBean = new BaseRespBean();
		if (bindingResult.hasErrors()) {
			log.warn("bindingResult has error");
			respBean.setResult(ErrorCodeEnum.PARAM_VALID_ERROR);
			respBean.setResultErrorMap(bindingResult);
			return respBean;
		}
		
		// 获取用户信息
		String userIdSession = (String) httpSession
				.getAttribute(ScfConsts.SESSION_USER_ID);
		log.debug("userIdSession: {}", userIdSession);

		Map<String, Object> paramMap = BeanUtil.beanToMap(reqBean);
		paramMap.put("createUserId", userIdSession);
		paramMap.put("relaCorpId", ScfCacheDict.relaCorpIdMap.get(reqBean.getCorpId()));
		
		respBean = corpOperateAnalyService.addCorpOperateAnaly(paramMap);

		return respBean;
	}

	@RequestMapping(value = "/corpOperateAnaly/mod", method = RequestMethod.POST, consumes = { "application/json" }, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody BaseRespBean corpOperateAnalyUpdate(
			@Valid @RequestBody CorpOperateAnalyUpdateReqBean reqBean,
			BindingResult bindingResult) throws IOException {
		BaseRespBean respBean = new BaseRespBean();
		if (bindingResult.hasErrors()) {
			log.warn("bindingResult has error");
			respBean.setResult(ErrorCodeEnum.PARAM_VALID_ERROR);
			respBean.setResultErrorMap(bindingResult);
			return respBean;
		}

		Map<String, Object> paramMap = BeanUtil.beanToMap(reqBean);
		respBean = corpOperateAnalyService.updateCorpOperateAnaly(paramMap);

		return respBean;
	}

	@RequestMapping(value = "/corpOperateAnaly/delete", method = RequestMethod.POST, consumes = { "application/json" }, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody BaseRespBean corpOperateAnalyDelete(
			@Valid @RequestBody RecUidReqBean reqBean,
			BindingResult bindingResult) throws IOException {
		BaseRespBean respBean = new BaseRespBean();
		if (bindingResult.hasErrors()) {
			log.warn("bindingResult has error");
			respBean.setResult(ErrorCodeEnum.PARAM_VALID_ERROR);
			respBean.setResultErrorMap(bindingResult);
			return respBean;
		}

		respBean = corpOperateAnalyService.deleteCorpOperateAnaly(reqBean.getRecUid());

		return respBean;
	}

}
