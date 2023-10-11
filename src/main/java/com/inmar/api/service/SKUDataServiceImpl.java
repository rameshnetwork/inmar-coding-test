package com.inmar.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inmar.api.dto.InputSKUData;
import com.inmar.api.dto.OutputSKUData;
import com.inmar.api.entity.SKUData;
import com.inmar.api.exception.SKUDataException;

import com.inmar.api.repository.SKUDataRepository;
import com.inmar.api.util.UtilityClass;

/*
 * This service class calculate final out and provide response
 * 
 */
@Service
public class SKUDataServiceImpl implements SKUDataService {

	@Autowired
	private SKUDataRepository skuDataRepository;

	@Override
	public List<OutputSKUData> getSKUdata(InputSKUData inputSKUData) {
		if (inputSKUData == null) {
			throw new SKUDataException("Invalid Input");
		}
		List<SKUData> skuDatas = skuDataRepository.findByLocationAndDepartmentAndCategoryAndSubCategory(
				inputSKUData.getLocation(), inputSKUData.getDepartment(), inputSKUData.getCategory(),
				inputSKUData.getSubCategory());

		return UtilityClass.convert(skuDatas);
	}

}
