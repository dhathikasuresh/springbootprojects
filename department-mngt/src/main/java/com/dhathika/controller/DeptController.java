package com.dhathika.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dhathika.model.Dept;
import com.dhathika.service.DeptServiceImpl;


@RestController
public class DeptController {

	@Autowired
	DeptServiceImpl deptServiceImpl;

	@PostMapping("/dept")
	public void saveDept(@RequestBody Dept dept) {
		System.out.println("dept received from json :" + dept);
		deptServiceImpl.saveDept(dept);
	}

	@GetMapping("/dept/{deptNo}")
	public Optional<Dept> getDeptByNo(@PathVariable int deptNo) {
		System.out.println("Dept number received from path variable :" + deptNo);

		return deptServiceImpl.getDeptByNo(deptNo);
	}
	@PutMapping("/dept")
    public Dept updateDept(@RequestBody Dept dept) {
    	return deptServiceImpl.updateDept(dept);
    }
	@GetMapping("/depts")
	public List<Dept> getAllDepts() {
		System.out.println(deptServiceImpl);
		return deptServiceImpl.getAllDepts();
	}

	@DeleteMapping("/delete/{deptNo}")
	public void deleteDept(@PathVariable int deptNo) {
		System.out.println("Dept number received from path variable :" + deptNo);

		deptServiceImpl.deleteDept(deptNo);
	}
}
