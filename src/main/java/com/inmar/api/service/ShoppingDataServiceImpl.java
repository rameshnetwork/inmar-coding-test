package com.inmar.api.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inmar.api.dto.ShoppingDataDto;
import com.inmar.api.entity.ShoppingCart;
import com.inmar.api.exception.ShoppingCartException;
import com.inmar.api.repository.ShoppingCartRepository;

@Service
public class ShoppingDataServiceImpl implements ShoppingDataService {

	@Autowired
	private ShoppingCartRepository shoppingCartRepository;

	@Override
	public List<String> getLocations() {
		return shoppingCartRepository.getLocations();
	}

	@Override
	public List<ShoppingDataDto> getDepartments(String location) {
		if (location == null) {
			throw new ShoppingCartException("Invalid Input");
		}
		return shoppingCartRepository.getDepartments(location);
	}

	@Override
	public List<ShoppingDataDto> getCategories(String location, String department) {
		if (location == null || department == null) {
			throw new ShoppingCartException("Invalid Input");
		}
		return shoppingCartRepository.getCategories(location, department);
	}

	@Override
	public List<ShoppingDataDto> getSubcategory(String location, String department, String category) {
		if (location == null || department == null || category == null) {
			throw new ShoppingCartException("Invalid Input");
		}
		return shoppingCartRepository.getSubcategory(location, department, category);
	}

	@Override
	public List<ShoppingDataDto> getAll(String location, String department, String category, String subcategory) {
		if (location == null || department == null || category == null || subcategory == null) {
			throw new ShoppingCartException("Invalid Input");
		}
		return shoppingCartRepository.getAll(location, department, category, subcategory);
	}

	@Override
	public ShoppingDataDto save(ShoppingDataDto shoppingDataDto) {
		if (shoppingDataDto == null) {
			throw new ShoppingCartException("Invalid Input");
		}
		ShoppingCart shoppingCart = new ShoppingCart();
		BeanUtils.copyProperties(shoppingDataDto, shoppingCart);
		shoppingCart = shoppingCartRepository.save(shoppingCart);
		BeanUtils.copyProperties(shoppingCart, shoppingDataDto);
		return shoppingDataDto;
	}

	@Override
	public void delete(ShoppingDataDto shoppingDataDto) {
		if (shoppingDataDto == null) {
			throw new ShoppingCartException("Invalid Input");
		}
		ShoppingCart shoppingCart = new ShoppingCart();
		BeanUtils.copyProperties(shoppingDataDto, shoppingCart);
		shoppingCartRepository.delete(shoppingCart);
	}
}
