package com.expenditureapp.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddRequest {
	private String expenditureName;
	private int price;
}
