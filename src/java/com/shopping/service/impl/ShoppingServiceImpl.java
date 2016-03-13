package com.shopping.service.impl;

import java.util.List;

import com.shopping.dao.ProductDao;
import com.shopping.dto.ProductDto;
import com.shopping.service.ShoppingService;

public class ShoppingServiceImpl implements ShoppingService {

	private ProductDao productDao;

	@Override
	public List<ProductDto> queryShopCartInfo(ProductDto productDto) {
		return this.productDao.queryProductList(productDto);
	}

	public ProductDto queryProductById(String productId) {
		return this.productDao.queryProductById(productId);
	}

	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

}
