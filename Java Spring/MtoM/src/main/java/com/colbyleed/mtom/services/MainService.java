package com.colbyleed.mtom.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colbyleed.mtom.models.Category;
import com.colbyleed.mtom.models.CategoryProduct;
import com.colbyleed.mtom.models.Product;
import com.colbyleed.mtom.repositories.CategoryRepository;
import com.colbyleed.mtom.repositories.ProductRepository;

@Service
public class MainService {
	
	@Autowired
	CategoryRepository categoryRepo;
	
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	CategoryProduct categoryProductRepo;
	
//	------------- CREATE --------------------	//
	public Category createCategory(Category newCategory) {
		return categoryRepo.save(newCategory);
	}
	
	public Product createProduct(Product newProduct) {
		return productRepo.save(newProduct);
	}

	
	
	
	
//	---------------- GET ONE -----------------	//
	public Category getOneCategory(Long categoryId) {
		return categoryRepo.findById(categoryId).orElse(null);		
	}
	
	public Product getOneProduct(Long productId) {
		return productRepo.findById(productId).orElse(null);
	}
	
}
