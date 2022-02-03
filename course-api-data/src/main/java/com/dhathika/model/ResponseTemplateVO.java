package com.dhathika.model;

public class ResponseTemplateVO {
	
	public Product product;
	public Dept dept;
	
	
	public ResponseTemplateVO() {
		
	}


	public ResponseTemplateVO(Product product, Dept dept) {
		
		this.product = product;
		this.dept = dept;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public Dept getDept() {
		return dept;
	}


	public void setDept(Dept dept) {
		this.dept = dept;
	}


	@Override
	public String toString() {
		return "ResponseTemplateVO [product=" + product + ", dept=" + dept + "]";
	}
	
	

}
