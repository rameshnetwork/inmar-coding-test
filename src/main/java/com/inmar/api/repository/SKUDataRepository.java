package com.inmar.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inmar.api.entity.SKUData;

@Repository
public interface SKUDataRepository extends JpaRepository<SKUData, Long> {

	public List<SKUData> findByLocationAndDepartmentAndCategoryAndSubCategory(String location, String department,
			String category, String subCategory);
}
