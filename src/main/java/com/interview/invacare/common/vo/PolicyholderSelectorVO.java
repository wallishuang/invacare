package com.interview.invacare.common.vo;

import io.swagger.v3.oas.annotations.media.Schema;

public class PolicyholderSelectorVO {

	@Schema(description = "保戶編號")
	private String code;
	@Schema(description = "保戶姓名")
	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
