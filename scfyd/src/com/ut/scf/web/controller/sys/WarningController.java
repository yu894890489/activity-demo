package com.ut.scf.web.controller.sys;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ut.scf.core.dict.PageInfoBean;
import com.ut.scf.core.util.BeanUtil;
import com.ut.scf.reqbean.sys.WarningReqBean;
import com.ut.scf.respbean.BaseRespBean;
import com.ut.scf.service.sys.IWarningService;
import com.ut.scf.web.controller.BaseJsonController;

@Controller
@RequestMapping("/warning")
public class WarningController extends BaseJsonController {

	private static final Logger log = LoggerFactory
			.getLogger(WarningController.class);
	@Resource
	private IWarningService iWarningService;

	// 获取批处理列表
	@RequestMapping(value = "/list")
	@ResponseBody
	public BaseRespBean batchInfoList(@Valid @RequestBody WarningReqBean reqBean)
			throws IOException {
		Map<String, Object> paramMap = BeanUtil.beanToMap(reqBean);
		PageInfoBean page = new PageInfoBean();
		page.setPageNumber(reqBean.getPageNumber());
		page.setPageSize(reqBean.getPageSize());
		BaseRespBean respBean = new BaseRespBean();
		respBean = iWarningService.warningInfoList(paramMap, page);
		return respBean;
	}

	// 查阅

	@RequestMapping(value = "/count")
	@ResponseBody
	public String warningInfoDetail(@Valid @RequestBody WarningReqBean reqBean)
			throws IOException {
		return iWarningService.warningInfoCount() + "";
	}

}
