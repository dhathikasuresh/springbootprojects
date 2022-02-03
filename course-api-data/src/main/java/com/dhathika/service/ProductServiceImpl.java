package com.dhathika.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dhathika.controller.ProductController;
import com.dhathika.model.Dept;
import com.dhathika.model.Product;
import com.dhathika.model.ResponseTemplateVO;
import com.dhathika.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	ProductRepository productRepository;
	
	private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	

	@Override
	public void saveProduct(Product product) {
		productRepository.save(product);
		
	}

	

	@Override
	public Optional<Product> getProductByNo(int productNo) {
		
		return productRepository.findById(productNo);
	}
	
	@Override
	public Product updateProduct(Product newProduct) {
		// TODO Auto-generated method stub
	Optional<Product> oldProduct = getProductByNo(newProduct.getProductNo());
		if(oldProduct.get().getProductName().equals(newProduct.getProductName())==false){
			oldProduct.get().setProductName(newProduct.getProductName());
		}
		if(oldProduct.get().getProductPrice()!=newProduct.getProductPrice()) {
			oldProduct.get().setProductPrice(newProduct.getProductPrice());
		}
		if(oldProduct.get().getProductType().equalsIgnoreCase(newProduct.getProductType())==false)
			oldProduct.get().setProductType(newProduct.getProductType());
		
		if(oldProduct.get().getDeptNumber()!=newProduct.getDeptNumber())
			oldProduct.get().setDeptNumber(newProduct.getDeptNumber());
		
		Product productUpdated = productRepository.save(oldProduct.get());
		return productUpdated;
		
	}

	@Override
	public List<Product> getAllProducts() {
		
		return productRepository.findAll();
	}

	@Override
	public void deleteProduct(int productNo) {
	 productRepository.deleteById(productNo);
		
	}



	@Override
	public Product fetchProductByName(String productName) {
		// TODO Auto-generated method stub
		return productRepository.findByproductNameIgnoreCase(productName);
	}



	@Override
	public ResponseTemplateVO getProductWithDepartment(int productNo) {
		LOGGER.info("in resttemplate using mehtod");
		ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
		Optional<Product> product = productRepository.findById(productNo);
		Dept dept = restTemplate.getForObject("http://localhost:8082/dept/" + product.get().getDeptNumber(), Dept.class);
		responseTemplateVO.setProduct(product.get());
		responseTemplateVO.setDept(dept);		
		return responseTemplateVO;
	}



	


	
   

}
