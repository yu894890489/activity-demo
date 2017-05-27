package com.ut.scf.web.controller.project;

import java.io.IOException;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ut.scf.reqbean.project.PayCommitmentListReqBean;
import com.ut.scf.respbean.BaseRespBean;
import com.ut.scf.service.project.IPayCommitmentService;

@Controller
@RequestMapping("/commitment")
public class PayCommitmentManagerController {
	@Resource
	private IPayCommitmentService iPayCommitmentService;

	@RequestMapping(value = "/list")
	@ResponseBody
	public BaseRespBean batchInfoList(
			@Valid @RequestBody PayCommitmentListReqBean reqBean)
			throws IOException {
		BaseRespBean respBean = iPayCommitmentService
				.payCommitmentInfoList(reqBean);
		return respBean;
	}
}
