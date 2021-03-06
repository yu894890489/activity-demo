package com.ut.scf.web.controller.project;

import java.io.IOException;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ut.scf.reqbean.project.ContractFileReqBean;
import com.ut.scf.reqbean.project.ContractReqBean;
import com.ut.scf.reqbean.project.ContractUpdateReqBean;
import com.ut.scf.respbean.BaseRespBean;
import com.ut.scf.service.project.IContractMagagerService;

@Controller
@RequestMapping("/contract")
public class ContractManagerController {
	@Resource
	private IContractMagagerService contractMagagerService;

	@RequestMapping(value = "/add")
	public @ResponseBody BaseRespBean contractAdd(
			@RequestBody ContractReqBean contractReqBean) throws IOException {
		BaseRespBean respBean = contractMagagerService
				.addFactorContract(contractReqBean);

		return respBean;
	}

	@RequestMapping(value = "/mod", method = RequestMethod.POST, consumes = { "application/json" }, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody BaseRespBean contractMod(
			@Valid @RequestBody ContractUpdateReqBean contractUpdateReqBean)
			throws IOException {
		BaseRespBean respBean = contractMagagerService
				.modFactorContract(contractUpdateReqBean);

		return respBean;
	}

	@RequestMapping(value = "/list")
	public @ResponseBody BaseRespBean contractList(
			@Valid @RequestBody ContractReqBean contractReqBean)
			throws IOException {
		BaseRespBean respBean = contractMagagerService
				.factorContractList(contractReqBean);

		return respBean;
	}

	@RequestMapping(value = "/fileList")
	public @ResponseBody BaseRespBean contractFileList(
			@Valid @RequestBody ContractFileReqBean contractReqBean)
			throws IOException {
		BaseRespBean respBean = contractMagagerService
				.factorContractFileList(contractReqBean);

		return respBean;
	}

	@RequestMapping(value = "/check")
	public @ResponseBody BaseRespBean checkFactorContract(
			@RequestBody ContractReqBean ContractReqBean) throws IOException {
		BaseRespBean respBean = contractMagagerService
				.checkFactorContact(ContractReqBean);

		return respBean;
	}
}
