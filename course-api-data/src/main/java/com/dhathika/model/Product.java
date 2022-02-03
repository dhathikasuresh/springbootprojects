package com.dhathika.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

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
@Entity
@ToString
public class Product  {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer productNo;
	
	@NotBlank(message="Please add product name")
	String productName;
	Double productPrice;
	Integer deptNumber;
	String productType;
	

	
	
}
