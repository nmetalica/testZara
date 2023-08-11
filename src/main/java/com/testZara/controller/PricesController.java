package com.testZara.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.testZara.request.PriceRequest;
import com.testZara.response.PriceResponse;
import com.testZara.service.PriceService;

@RestController
public class PricesController {
	
	@Autowired
	PriceService service;
	
	@PostMapping("/getPrice")
	public PriceResponse getPrice(@RequestBody PriceRequest request) {
		return service.getPrice(request);
	}

}
