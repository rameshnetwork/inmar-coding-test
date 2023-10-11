package com.inmar.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inmar.api.dto.ShoppingDataDto;
import com.inmar.api.entity.ShoppingCart;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
	
	
	@Query("SELECT distinct location FROM ShoppingCart u ")
	public List<String> getLocations();
	
	//@Query("SELECT   u  FROM ShoppingCart u where u.location = :location ")
	@Query("SELECT  distinct new com.inmar.api.dto.ShoppingDataDto(u.location,u.department)  FROM ShoppingCart u where u.location = :location ")
	//new com.inmar.api.dto.ShoppingDataDto(c.location,c.department)
	public List<ShoppingDataDto> getDepartments(String location);
	
	@Query("SELECT  distinct new com.inmar.api.dto.ShoppingDataDto(u.location,u.department, u.category)  FROM ShoppingCart u where u.location = :location and u.department = :department")
	public List<ShoppingDataDto> getCategories(String location, String department);
	
	@Query("SELECT  distinct new com.inmar.api.dto.ShoppingDataDto(u.location,u.department, u.category, u.subCategory)  FROM ShoppingCart u where u.location = :location and u.department = :department and u.category = :category ")
	public List<ShoppingDataDto> getSubcategory(String location, String department,String category);
	
	@Query("SELECT  distinct new com.inmar.api.dto.ShoppingDataDto(u.location,u.department, u.category, u.subCategory)  FROM ShoppingCart u where u.location = :location and u.department = :department and u.category = :category and u.subCategory = :subCategory ")
	public List<ShoppingDataDto> getAll(String location, String department,String category, String subCategory);

	
}
