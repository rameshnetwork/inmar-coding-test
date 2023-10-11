package com.inmar.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inmar.api.dto.InputSKUData;
import com.inmar.api.dto.OutputSKUData;
import com.inmar.api.service.SKUDataService;

@RestController
public class SKUDataController {
	@Autowired
	private SKUDataService skuDataService;
	
	Logger logger = LoggerFactory.getLogger(SKUDataController.class);

	@PostMapping("/skudata")
	public List<OutputSKUData> getSKUdata(@RequestBody InputSKUData inputSKUData) {
		logger.info("inputSKUData :"+ inputSKUData);
		System.out.println("inputSKUData :"+ inputSKUData);
		return skuDataService.getSKUdata(inputSKUData);
	}
}
