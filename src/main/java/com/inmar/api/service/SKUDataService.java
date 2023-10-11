package com.inmar.api.service;

import java.util.List;

import com.inmar.api.dto.InputSKUData;
import com.inmar.api.dto.OutputSKUData;

public interface SKUDataService {
	public List<OutputSKUData> getSKUdata(InputSKUData inputSKUData) ;
}
