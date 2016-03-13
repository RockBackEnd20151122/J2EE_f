package com.shopping.dao;

import java.util.List;

import com.shopping.dto.ProductDto;

public interface ProductDao {
	public List<ProductDto> queryProductList(ProductDto productDto);
	public ProductDto queryProductById(String productId);
}	
