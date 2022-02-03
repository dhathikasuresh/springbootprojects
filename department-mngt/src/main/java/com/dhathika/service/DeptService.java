package com.dhathika.service;

import java.util.List;
import java.util.Optional;

import com.dhathika.model.Dept;

public interface DeptService {
	public void saveDept(Dept dept);
	public Dept updateDept(Dept dept);
	public Optional<Dept> getDeptByNo(int deptNo);	
	public List<Dept> getAllDepts();	
	public void deleteDept(int deptNo);
	
	
}
