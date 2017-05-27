package com.ut.scf.web.controller.asset;

import java.io.IOException;
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
import com.ut.scf.core.dict.ScfConsts;
import com.ut.scf.core.util.BeanUtil;
import com.ut.scf.reqbean.RecUidReqBean;
import com.ut.scf.reqbean.asset.TransferManagerAddReqBean;
import com.ut.scf.reqbean.asset.TransferManagerListReqBean;
import com.ut.scf.reqbean.asset.TransferManagerUpdateReqBean;
import com.ut.scf.respbean.BaseRespBean;
import com.ut.scf.service.asset.ITransferManagerService;
import com.ut.scf.web.controller.BaseJsonController;

/**
 * 资产转让的控制类
 * @author changxin
 *
 */
@Controller
@RequestMapping("/transfer")
public class TransferManagerController extends BaseJsonController{
	private static final Logger log = LoggerFactory
			.getLogger(TransferManagerController.class);
	@Resource
	private ITransferManagerService TransferManagerService;
	@RequestMapping(value = "/list", method = RequestMethod.POST, consumes = { "application/json" }, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody BaseRespBean TransferManagerList(
			HttpSession httpSession,
			@Valid @RequestBody TransferManagerListReqBean reqBean,
			BindingResult bindingResult) throws IOException {
		BaseRespBean respBean = new BaseRespBean();
		if (bindingResult.hasErrors()) {
			log.warn("bindingResult has error");
			respBean.setResult(ErrorCodeEnum.PARAM_VALID_ERROR);
			respBean.setResultErrorMap(bindingResult);
			return respBean;
		}
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
	/*	if (roleTypeSession == ScfBizConsts.ROLE_TYPE_FACTOR) {
			paramMap.put("relaCorpId", corpIdSession);
				if (!roleIdSession.equals(ScfBizConsts.ROLE_ID_FACTOR_ADMIN)) {
					paramMap.put("createUserId", userIdSession);
				}
			} else if (roleTypeSession != ScfBizConsts.ROLE_TYPE_PLAT) {
					paramMap.put("corpId", corpIdSession);
				}*/
		if(roleTypeSession != ScfBizConsts.ROLE_TYPE_PLAT){
			paramMap.put("corpId", corpIdSession);	
		}		
		PageInfoBean page = new PageInfoBean();
		page.setPageNumber(reqBean.getPageNumber());
		page.setPageSize(reqBean.getPageSize());
		respBean = TransferManagerService.getTransferList(paramMap, page);
		return respBean;
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = { "application/json" }, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody BaseRespBean TransferManagerAdd(
			HttpSession httpSession,
			@Valid @RequestBody TransferManagerAddReqBean reqBean,
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
	//	paramMap.put("relaCorpId", ScfCacheDict.relaCorpIdMap.get(reqBean.getCorpId()));
		respBean = TransferManagerService.addTransfer(paramMap);
		return respBean;
	}
	@RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = { "application/json" }, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody BaseRespBean TransferManagerDelete(
			HttpSession httpSession,
			@Valid @RequestBody RecUidReqBean reqBean,
			BindingResult bindingResult) throws IOException {
		BaseRespBean respBean = new BaseRespBean();
		if (bindingResult.hasErrors()) {
			log.warn("bindingResult has error");
			respBean.setResult(ErrorCodeEnum.PARAM_VALID_ERROR);
			respBean.setResultErrorMap(bindingResult);
			return respBean;
		}
		String recUid = reqBean.getRecUid();
		respBean = TransferManagerService.deleteTransfer(recUid);
		return respBean;
	}
	@RequestMapping(value = "/mod", method = RequestMethod.POST, consumes = { "application/json" }, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody BaseRespBean TransferManagerUpdate(
			HttpSession httpSession,
			@Valid @RequestBody TransferManagerUpdateReqBean reqBean,
			BindingResult bindingResult) throws IOException {
		BaseRespBean respBean = new BaseRespBean();
		if (bindingResult.hasErrors()) {
			log.warn("bindingResult has error");
			respBean.setResult(ErrorCodeEnum.PARAM_VALID_ERROR);
			respBean.setResultErrorMap(bindingResult);
			return respBean;
		}
		Map<String, Object> paramMap = BeanUtil.beanToMap(reqBean);
		respBean = TransferManagerService.updateTransfer(paramMap);
		return respBean;
	}
}
