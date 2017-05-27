package com.ut.scf.web.controller.project;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.activiti.engine.impl.util.json.JSONArray;
import org.activiti.engine.impl.util.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ut.scf.respbean.BaseRespBean;
import com.ut.scf.respbean.ListRespBean;
import com.ut.scf.service.project.IAgencyService;
import com.ut.scf.web.controller.BaseJsonController;
@Controller
@RequestMapping("/agency")
public class AgencyManageController extends BaseJsonController{

	@Resource
	private IAgencyService agencyService;
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public  BaseRespBean addAgency(HttpSession httpSession,
			HttpServletRequest request, HttpServletResponse response){
		String json = request.getParameter("json");
		//JSONObject jsonObject = new JSONObject(json);
		agencyService.startProcess(json,httpSession);
		
		return null;
		
	}

	@RequestMapping(value = "/getDaibanList", method = RequestMethod.POST,produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String getDaibanList(HttpSession httpSession){
		BaseRespBean baseRespBean = new BaseRespBean();
		ListRespBean daibanList = agencyService.getDaibanList(httpSession);
		return new JSONArray(daibanList.getDataList()).toString();
	}
	
	
}
