package com.cafe24.aoptest;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

	public ProductVo find(String name) {
	
		System.out.println("finding........");
		
		if(false) {
			throw new RuntimeException("my exception");
		}
		
		return new ProductVo(name);
	}
	
}
