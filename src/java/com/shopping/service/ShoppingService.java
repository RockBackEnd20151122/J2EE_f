package com.shopping.service;

import java.util.List;

import com.shopping.dto.ProductDto;

public interface ShoppingService {
	public List<ProductDto> queryShopCartInfo(ProductDto productDto);
	public ProductDto queryProductById(String productId);
}
