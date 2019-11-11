package com.xiaobaiai.product;

import io.swagger.annotations.ApiModel;

@ApiModel(value="Product",description="对产品定义的描述")
public class Product {
	private String id;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}