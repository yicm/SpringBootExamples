package com.xiaobaiai.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1")
@Api(tags={"产品操作分组4"},  protocols = "https", hidden = true)
public class ProductServiceController {
	@Autowired
	ProductService productService;
	
	@ApiParam(value="产品ID值", required=true)
	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("id") String id) {
		productService.deleteProduct(id);
		return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
	}
	@ApiImplicitParams({
		@ApiImplicitParam(name="id", value="产品ID值", required=true),
		@ApiImplicitParam(name="product", value="产品内容", required=true, dataType="object")
	})
	@RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
		productService.updateProduct(id, product);
		return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public ResponseEntity<Object> createProduct(@RequestBody Product product) {
		productService.createProduct(product);
		return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
	}

	
	@ApiOperation(value = "获取所有产品", notes = "每调用一次，就耗费流量100M",response =Product.class, responseContainer="List")
	@ApiResponses({
        @ApiResponse(code = 200, message = "成功！", response=Product.class),
        @ApiResponse(code = 401, message = "未授权！", response=Product.class),
        @ApiResponse(code = 404, message = "页面未找到！", response=Product.class),
        @ApiResponse(code = 403, message = "出错了！", response=Product.class)
	})
	@GetMapping(value = "/products")
	public ResponseEntity<Object> getProduct() {
		return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
	}
}
