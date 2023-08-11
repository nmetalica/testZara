package com.testZara.service;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testZara.model.Price;
import com.testZara.repository.PricesRespository;
import com.testZara.request.PriceRequest;
import com.testZara.response.PriceResponse;

@Service
public class PriceServiceImpl implements PriceService {
	
	@Autowired
	PricesRespository repository;
	
	public PriceResponse getPrice(PriceRequest request) {
		return mapper(
				repository.findApplicablePrice(
						request.getAppTime(),
						request.getBrandId(),
						request.getProductId()));
	}
	
	private PriceResponse mapper(Price price) {
		return new PriceResponse(
				price.getPriceList(),
				price.getBrandId(),
				price.getStartDate(),
				price.getEndDate(),
				price.getProductId(),
				price.getPriority(),
				price.getPrice(),
				price.getCurrency());
	}

}
