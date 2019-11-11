package com.xiaobaiai.product;

import java.util.Collection;

public interface ProductService {
	public abstract void createProduct(Product user);
	public abstract void updateProduct(String id, Product user);
	public abstract void deleteProduct(String id);
	public abstract Collection<Product> getProducts();
}
