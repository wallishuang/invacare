package com.interview.invacare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.interview.invacare.common.vo.PolicyholderCreatedVO;
import com.interview.invacare.repository.Policyholder;
import com.interview.invacare.repository.PolicyholderRepository;
import com.interview.invacare.service.PolicyholderService;

@Controller
public class MainViewController {
	@Autowired
	private PolicyholderService service;
	@Autowired
	PolicyholderRepository repository;

	@GetMapping("/")
	public String showUserList(Model model) throws Exception {
		model.addAttribute("createUser", new PolicyholderCreatedVO());
		
		List<Policyholder> result = service.getHolderByView("");
		model.addAttribute("orgChartDataList", result);
		
		return "index";
	}

	@PostMapping("/adduser")
	public String createHolder(Model model, @ModelAttribute PolicyholderCreatedVO createUser) throws Exception {
		String code = service.addHolder(createUser);
		model.addAttribute("createUser", createUser);
		
		List<Policyholder> result= service.getHolderByView("");
		model.addAttribute("orgChartDataList", result);
		
		return "index";
	}

	@GetMapping("/queryuser")
	public String queryHolder(Model model, @ModelAttribute("code") String code) throws Exception {
		model.addAttribute("createUser", new PolicyholderCreatedVO());
		
		List<Policyholder> holderList = service.getHolderByView(code);
		model.addAttribute("orgChartDataList", holderList);
		return "index";
	}

	
}