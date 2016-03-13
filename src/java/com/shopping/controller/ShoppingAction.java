package com.shopping.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.shopping.dto.ProductDto;
import com.shopping.service.ShoppingService;

public class ShoppingAction extends ActionSupport {
	private ShoppingService shoppingService;
	private ProductDto productDto;
	private List<ProductDto> productDtoList;
	private String message;
	private List<ProductDto> productShopCarList;
	private List<String> productList;
	private List<Integer> productCountList;

	public String queryProduct() {
		this.productDtoList = this.shoppingService
				.queryShopCartInfo(productDto);
		return this.SUCCESS;
	}

	public String addShoppingCart() {
		HttpSession hs = ServletActionContext.getRequest().getSession();
		Map<String, Integer> shopCarMap = (Map<String, Integer>) hs
				.getAttribute("shopCar");
		if (shopCarMap == null) {
			shopCarMap = new HashMap<String, Integer>();
		}

		Integer count = shopCarMap.get(productDto.getProductId());
		if (count == null) {
			count = 0;
		}

		count++;
		shopCarMap.put(productDto.getProductId(), count);
		hs.setAttribute("shopCar", shopCarMap);

		this.message = "添加成功";
		return this.SUCCESS;
	}

	public String queryShopCart() {
		HttpSession hs = ServletActionContext.getRequest().getSession();
		Map<String, Integer> shopCarMap = (Map<String, Integer>) hs
				.getAttribute("shopCar");
		if (shopCarMap != null && shopCarMap.size() > 0) {
			this.productShopCarList = new ArrayList<ProductDto>();
			for (String productId : shopCarMap.keySet()) {
				ProductDto productDtoTemp = this.shoppingService
						.queryProductById(productId);
				productDtoTemp.setProductByCount(shopCarMap.get(productId));
				this.productShopCarList.add(productDtoTemp);
			}
		}
		return this.SUCCESS;
	}

	public String updateShopCart() {
		System.out.println("aaaaaaa" + productList);
		System.out.println("bbbbbbbbbbb" + productCountList);

		HttpSession hs = ServletActionContext.getRequest().getSession();
		Map<String, Integer> shopCarMap = (Map<String, Integer>) hs
				.getAttribute("shopCar");
		shopCarMap.clear();
		for (int i = 0; i < this.productList.size(); i++) {
			shopCarMap.put(productList.get(i), productCountList.get(i));
		}
		return this.queryShopCart();
	}

	public ShoppingService getShoppingService() {
		return shoppingService;
	}

	public void setShoppingService(ShoppingService shoppingService) {
		this.shoppingService = shoppingService;
	}

	public ProductDto getProductDto() {
		return productDto;
	}

	public void setProductDto(ProductDto productDto) {
		this.productDto = productDto;
	}

	public List<ProductDto> getProductDtoList() {
		return productDtoList;
	}

	public void setProductDtoList(List<ProductDto> productDtoList) {
		this.productDtoList = productDtoList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<ProductDto> getProductShopCarList() {
		return productShopCarList;
	}

	public void setProductShopCarList(List<ProductDto> productShopCarList) {
		this.productShopCarList = productShopCarList;
	}

	public List<String> getProductList() {
		return productList;
	}

	public void setProductList(List<String> productList) {
		this.productList = productList;
	}

	public List<Integer> getProductCountList() {
		return productCountList;
	}

	public void setProductCountList(List<Integer> productCountList) {
		this.productCountList = productCountList;
	}

}
