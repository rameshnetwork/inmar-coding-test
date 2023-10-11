package com.inmar.api.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 * 
 * 
 * This class work as Input & OutPut DTO
 * serverScore: provides input score & after calculation provides output 
 * receiverScore: provides input score & after calculation provides output 
 * whoWin: who win the point and also who win the set
 * 
 * We inject this class in Controller and Service
 * 
 */
@Setter
@Getter
@ToString
public class ShoppingDataDto {
	private String location;
	private String department;
	private String category;
	private String subCategory;

	public ShoppingDataDto(String location, String department) {
		this.location = location;
		this.department = department;
	}

	public ShoppingDataDto(String location, String department, String category) {
		this.location = location;
		this.department = department;
		this.category = category;
	}

	public ShoppingDataDto(String location, String department, String category, String subCategory) {
		this.location = location;
		this.department = department;
		this.category = category;
		this.subCategory = subCategory;
	}

}
