package com.inmar.api.util;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inmar.api.dto.OutputSKUData;
import com.inmar.api.entity.SKUData;

public class UtilityClass {
	
	public static List<OutputSKUData> convert(List<SKUData> entityInput) {
		ObjectMapper mapper = new ObjectMapper();
	    return entityInput.stream().map(o -> mapper.convertValue(o, OutputSKUData.class)).collect(Collectors.toList());
	}

}
