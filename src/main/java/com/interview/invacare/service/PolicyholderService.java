package com.interview.invacare.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.interview.invacare.common.DataNotFoundException;
import com.interview.invacare.common.vo.PolicyholderCreatedVO;
import com.interview.invacare.common.vo.PolicyholderSelectorVO;
import com.interview.invacare.common.vo.PolicyholderVO;
import com.interview.invacare.repository.Policyholder;
import com.interview.invacare.repository.PolicyholderRepository;

@Service
public class PolicyholderService {

	@Autowired PolicyholderRepository repository;
	
	/**
	 * 取得所有保戶編號
	 * @return
	 * @throws Exception
	 */
	public List<PolicyholderSelectorVO> getAllCode() throws Exception {
		List<PolicyholderSelectorVO> reulst = new ArrayList<>();
		List<Policyholder> modelList = repository.findCodeOrderById();
		if(!CollectionUtils.isEmpty(modelList)) {
			for (Policyholder model :modelList) {
				PolicyholderSelectorVO vo = new PolicyholderSelectorVO();
				vo.setName(model.getName());
				vo.setCode(model.getCode());
				reulst.add(vo);
			}
		}
		
		return reulst;
	}

	/**
	 * 依編號取得保戶資訊
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public PolicyholderVO getHolder(String code) throws Exception {
		// 依編號取得保戶資訊
		Policyholder entity = repository.findByCode(code);
		if (entity == null) {
			throw new DataNotFoundException("data not found");
		}
		PolicyholderVO vo = toVO(entity);
		
		// 依編號取得該保戶下的子節點
		List<Policyholder> subEntities = repository.findByParentCodeOrderByParentPosition(code);
		if (CollectionUtils.isEmpty(subEntities)) {
			return vo;
		}

		List<PolicyholderVO> voLeftList = new ArrayList<>();
		List<PolicyholderVO> voRightList = new ArrayList<>();
		
		if (!CollectionUtils.isEmpty(subEntities)) {
			// 遞迴尋找子節點是否能繼續往下，直到子節點沒有節點
			for (Policyholder holder : subEntities) {
				PolicyholderVO subVO = getHolder(holder.getCode());
				if (subVO.getPosition().equals(Policyholder.POSITION.L.name())) {
					voLeftList.add(subVO);
				} else if (subVO.getPosition().equals(Policyholder.POSITION.R.name())) {
					voRightList.add(subVO);
				}
			}
		}

		vo.setL(voLeftList);
		vo.setR(voRightList);

		return vo;
	}

	/**
	 * 依編號取得上層保戶資訊
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public PolicyholderVO getTopHolder(String code) throws Exception {
		Policyholder entity = repository.findByCode(code);
		if (entity == null) {
			throw new DataNotFoundException("data not found");
		}
		return getHolder(entity.getParentCode());
	}

	/**
	 * 新增保戶
	 * @param createVO
	 * @throws Exception
	 */
	public void addHolder(PolicyholderCreatedVO createVO) throws Exception {
		Policyholder entity = new Policyholder();
		entity.setName(createVO.getName());
		entity.setIntroducerCode(createVO.getIntroducerCode());
		entity.setCreatedTime(new Date());
		entity.setUpdatedTime(new Date());

		long count = repository.count();
		if (count > 0) {
			if (StringUtils.isBlank(createVO.getIntroducerCode())) {
				Policyholder rootEntity = repository.findRootCode();
				entity = this.findAvalibleParentCode(entity, rootEntity.getCode(), true);
			} else {
				Policyholder check = repository.findByCode(createVO.getIntroducerCode());
				if(check == null) {
					throw new DataNotFoundException(String.format("%s code not found", createVO.getIntroducerCode()));
				}
				entity = this.findAvalibleParentCode(entity, createVO.getIntroducerCode(), true);
			}
		} 

		Policyholder responseEntity = repository.save(entity);
		responseEntity.setCode(String.format("%09d", responseEntity.getId()));
		repository.save(responseEntity);
	}
	
	/**
	 * 為新保戶尋找可用的父節點，如果沒有介紹人則依序從根節點開始，從左至右向下增加
	 * @param entity　新增保戶物件
	 * @param introCode　介紹人編號
	 * @param isSameLevel　目前查詢的進度是否為同一個階層
	 * @return
	 */
	private Policyholder findAvalibleParentCode(Policyholder entity, String introCode, boolean isSameLevel) {
		List<Policyholder> children = repository.findByParentCodeOrderByParentPosition(introCode);
		if(CollectionUtils.isEmpty(children)) {
			entity.setParentCode(introCode);
			entity.setParentPosition(Policyholder.POSITION.L.name());
		} else {
			if (children.size() > 1) { // 代表介紹人的分支已滿，往下找
				if(isSameLevel) {
					for(Policyholder child:children) {
						if(StringUtils.isBlank(entity.getParentCode())) {
							entity = findAvalibleParentCode(entity, child.getCode(), false);
							break;
						}
					}										
				} 
				// 同層的沒找從最左邊開始繼續找
				if(StringUtils.isBlank(entity.getParentCode())) {
					for(Policyholder child:children) {	
						if(StringUtils.isBlank(entity.getParentCode())) {
							entity = findAvalibleParentCode(entity, child.getCode(), true);	
							break;
						}
					}
				}
			} else { // 介紹人底下只有一個分支
				entity.setParentCode(introCode);
				entity.setParentPosition(Policyholder.POSITION.R.name());
			}
		}
		return entity;
	}

	private PolicyholderVO toVO(Policyholder entity) {
		PolicyholderVO vo = new PolicyholderVO();
		vo.setCode(entity.getCode());
		vo.setName(entity.getName());
		vo.setPosition(entity.getParentPosition());
		vo.setIntroducerCode(entity.getIntroducerCode());
		vo.setRegistrationDate(entity.getCreatedTime());
		vo.setDirect(false);

		if (entity.getParentCode() != null && entity.getIntroducerCode() != null
				&& entity.getParentCode().equals(entity.getIntroducerCode())) {
			vo.setDirect(true);
		}
		return vo;
	}
}
