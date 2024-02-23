package com.interview.invacare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.interview.invacare.common.vo.PolicyholderCreatedVO;
import com.interview.invacare.common.vo.PolicyholderSelectorVO;
import com.interview.invacare.common.vo.PolicyholderVO;
import com.interview.invacare.service.PolicyholderService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Policyholder", description = "保戶相關")
public class PolicyholderController {
	@Autowired
	private PolicyholderService service;

	@Operation(summary = "查詢所有保戶編號")
	@GetMapping("/api/policyholders/codes")
	public List<PolicyholderSelectorVO> getAllHolder() throws Exception {
		return service.getAllCode();
	}

	@Operation(summary = "保戶查詢")
	@GetMapping("/api/policyholders")
	public PolicyholderVO getHolder(@RequestParam(value = "code") String code) throws Exception {
		return service.getHolder(code);
	}

	@Operation(summary = "保戶上層查詢")
	@GetMapping("/api/policyholders/{code}/top")
	public PolicyholderVO getTopHolder(@PathVariable(value = "code") String code) throws Exception {
		return service.getTopHolder(code);
	}

	@Operation(summary = "新增保戶編號")
	@PostMapping
	@GetMapping("/api/policyholders")
	public void createHolder(@RequestBody @Validated PolicyholderCreatedVO vo) throws Exception {
		service.addHolder(vo);
	}

}
