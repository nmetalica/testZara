package com.testZara.service;

import com.testZara.request.PriceRequest;
import com.testZara.response.PriceResponse;

public interface PriceService {

	public PriceResponse getPrice(PriceRequest request);
}
