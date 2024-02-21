package com.interview.invacare.common.vo;

import java.util.Date;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

public class PolicyholderVO {
	@Schema(description = "保戶編號")
	private String code;
	@Schema(description = "保戶姓名")
	private String name;
	@Schema(description = "註冊日")
	private Date registrationDate;
	@Schema(description = "介紹人編號")
	private String introducerCode;
	@Schema(description = "在父節點的位置")
	private String position;
	@Schema(description = "是否為直接介紹")
	private boolean direct;
	private List<PolicyholderVO> l;
	private List<PolicyholderVO> r;
	
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

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getIntroducerCode() {
		return introducerCode;
	}

	public void setIntroducerCode(String introducerCode) {
		this.introducerCode = introducerCode;
	}

	public List<PolicyholderVO> getL() {
		return l;
	}

	public void setL(List<PolicyholderVO> l) {
		this.l = l;
	}

	public List<PolicyholderVO> getR() {
		return r;
	}

	public void setR(List<PolicyholderVO> r) {
		this.r = r;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public boolean isDirect() {
		return direct;
	}

	public void setDirect(boolean direct) {
		this.direct = direct;
	}

}
