package com.cafe24.aoptest;

public class ProductVo {

	private String name;
	
	public ProductVo() {
		
	}
	public ProductVo(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "ProductVo [name=" + name + "]";
	}
	
}
