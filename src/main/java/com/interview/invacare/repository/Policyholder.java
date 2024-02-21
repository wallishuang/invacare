package com.interview.invacare.repository;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "policyholder")
@SequenceGenerator(sequenceName = "policyholder_id_seq", allocationSize = 1, name = "policyholder_seq")
public class Policyholder {
	public enum POSITION {
		R, L
	};

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "policyholder_seq")
	private Integer id;
	private String code;
	private String name;
	private String introducerCode;
	private String parentCode;
	private String parentPosition;
	private Date createdTime;
	private Date updatedTime;

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

	public String getIntroducerCode() {
		return introducerCode;
	}

	public void setIntroducerCode(String introducerCode) {
		this.introducerCode = introducerCode;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getParentPosition() {
		return parentPosition;
	}

	public void setParentPosition(String parentPosition) {
		this.parentPosition = parentPosition;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
