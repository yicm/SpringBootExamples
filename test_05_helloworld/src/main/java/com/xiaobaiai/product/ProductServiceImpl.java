package com.xiaobaiai.product;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
	private static Map<String, Product> productRepo = new HashMap<>();
	static {
		Product ethan = new Product();
		ethan.setId("1");
		ethan.setName("iPhone");
		productRepo.put(ethan.getId(), ethan);

		Product xiaoming = new Product();
		xiaoming.setId("2");
		xiaoming.setName("Xiaomi");
		productRepo.put(xiaoming.getId(), xiaoming);
	}
	
	@Override
	public void createProduct(Product product) {
		// TODO Auto-generated method stub
		productRepo.put(product.getId(), product);
	}

	@Override
	public void updateProduct(String id, Product product) {
		// TODO Auto-generated method stub
		productRepo.remove(id);
		product.setId(id);
		productRepo.put(id, product);
	}

	@Override
	public void deleteProduct(String id) {
		// TODO Auto-generated method stub
		productRepo.remove(id);
	}

	@Override
	public Collection<Product> getProducts() {
		// TODO Auto-generated method stub
		return productRepo.values();
	}
}
