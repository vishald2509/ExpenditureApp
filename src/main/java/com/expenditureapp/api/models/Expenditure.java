package com.expenditureapp.api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Document(collection = "expenditure") @Data @AllArgsConstructor
public class Expenditure {
	
	@Id
	String id;
	String expenditure_name;
	int price;
	
}