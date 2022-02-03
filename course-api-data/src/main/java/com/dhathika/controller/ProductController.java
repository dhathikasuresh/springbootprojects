package com.dhathika.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhathika.model.Product;
import com.dhathika.model.ResponseTemplateVO;
import com.dhathika.service.ProductServiceImpl;

@RestController
@RequestMapping("/prd")
public class ProductController {

	@Autowired
	ProductServiceImpl productServiceImpl;
	
	

	private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@PostMapping("/product")
	public void saveProduct(@Valid @RequestBody Product product){       
		LOGGER.info("inside save product method");
		System.out.println("product received from json :" + product);
		productServiceImpl.saveProduct(product);
	}
	@GetMapping("/message")
	public String sendMessage(){       
		
		System.out.println("product received from json :");
		return "String message";
	}

	@GetMapping("/product/{productNo}")
	public Optional<Product> getProductByNo(@PathVariable int productNo) {
		LOGGER.info("inside get product by number method ");
		System.out.println("Product number received from path variable :" + productNo);

		return productServiceImpl.getProductByNo(productNo);
	}
	@PutMapping("/product")
    public Product updateProduct(@Valid @RequestBody Product product) {
		LOGGER.info("inside update product method");
		return productServiceImpl.updateProduct(product);
    }
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		LOGGER.info("inside get all product method");
		System.out.println(productServiceImpl);
		return productServiceImpl.getAllProducts();
	}

	@DeleteMapping("/delete/{productNo}")
	public void deleteProduct(@PathVariable int productNo) {
		LOGGER.info("inside delete product method");
		System.out.println("Product number received from path variable :" + productNo);

		productServiceImpl.deleteProduct(productNo);
	}
	@GetMapping("/products/name/{name}")
	public Product fetchProductByName(@PathVariable("name") String productName) {
		LOGGER.info("inside get product by name method");
		return productServiceImpl.fetchProductByName(productName);
	}
	
	@GetMapping("/productanddept/{productNo}")
	public ResponseTemplateVO getProductWithDepartment(@PathVariable int productNo) {
		LOGGER.info("inside get product with department method controller");
		return productServiceImpl.getProductWithDepartment(productNo);
		
	}
}
