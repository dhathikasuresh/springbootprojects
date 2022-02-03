package com.dhathika.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Setter
@Getter

@ToString
public class Dept  {

	Integer deptNo;	
	String deptName;
	String deptLocation;	
	
}
