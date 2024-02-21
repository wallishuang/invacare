package com.interview.invacare.common.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PolicyholderCreatedVO {
	
	@NotBlank
	@Size(max = 50)
	@Schema(description = "保戶姓名")
	private String name;
	@Schema(description = "介紹人編號")
	private String introducerCode;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntroducerCode() {
		return introducerCode;
	}
	public void setIntroducerCode(String introducerCode) {
		this.introducerCode = introducerCode;
	}
	
	
}
