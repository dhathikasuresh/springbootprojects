package com.dhathika.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhathika.model.Dept;
import com.dhathika.repository.DeptRepository;

@Service
public class DeptServiceImpl implements DeptService{
	
	@Autowired
	DeptRepository deptRepository;

	@Override
	public void saveDept(Dept dept) {
		deptRepository.save(dept);
		
	}
	@Override
	public Optional<Dept> getDeptByNo(int deptNo) {
		
		return deptRepository.findById(deptNo);
	}
	
	@Override
	public Dept updateDept(Dept newDept) {
		// TODO Auto-generated method stub
	Optional<Dept> oldDept = getDeptByNo(newDept.getDeptNo());
		if(oldDept.get().getDeptName().equals(newDept.getDeptName())==false){
			oldDept.get().setDeptName(newDept.getDeptName());
		}
		if(oldDept.get().getDeptLocation().equals(newDept.getDeptLocation())==false){
			oldDept.get().setDeptLocation(newDept.getDeptLocation());
		}
		
		Dept deptUpdated = deptRepository.save(oldDept.get());
		return deptUpdated;
		
	}

	@Override
	public List<Dept> getAllDepts() {
		
		return deptRepository.findAll();
	}

	@Override
	public void deleteDept(int deptNo) {
	 deptRepository.deleteById(deptNo);
		
	}
	
   

}
