package com.interview.invacare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PolicyholderRepository extends CrudRepository<Policyholder, String> {
	public List<Policyholder> findAll();
	public Policyholder findByCode(String code);
	public List<Policyholder> findByParentCodeOrderByParentPosition(String ParentCode);
	
	@Query("SELECT c FROM Policyholder c ORDER BY c.id")
	public List<Policyholder> findCodeOrderById();
	
	@Query("SELECT c FROM Policyholder c WHERE c.parentCode IS NULL OR c.parentCode = ''")
	public Policyholder findRootCode();
	
}
