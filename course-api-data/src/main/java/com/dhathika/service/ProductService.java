package com.dhathika.service;

import java.util.List;
import java.util.Optional;

import com.dhathika.model.Product;
import com.dhathika.model.ResponseTemplateVO;

public interface ProductService {
	public void saveProduct(Product product);
	public Product updateProduct(Product product);
	public Optional<Product> getProductByNo(int productNo);	
	public List<Product> getAllProducts();	
	public void deleteProduct(int productNo);
	public Product fetchProductByName(String productName);
	public ResponseTemplateVO getProductWithDepartment(int productNo);
	
	
}
