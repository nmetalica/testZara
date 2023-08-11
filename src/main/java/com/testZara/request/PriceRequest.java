package com.testZara.request;

import java.time.LocalDateTime;

public class PriceRequest {
	public LocalDateTime getAppTime() {
		return appTime;
	}
	public void setAppTime(LocalDateTime appTime) {
		this.appTime = appTime;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	LocalDateTime appTime;
	int productId;
	int brandId;
	public PriceRequest(LocalDateTime appTime, int productId, int brandId) {
		super();
		this.appTime = appTime;
		this.productId = productId;
		this.brandId = brandId;
	}
	
	

}
