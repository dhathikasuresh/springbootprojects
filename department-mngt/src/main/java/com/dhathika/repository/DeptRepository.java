package com.dhathika.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhathika.model.Dept;

public interface DeptRepository extends JpaRepository<Dept, Integer>{

}
