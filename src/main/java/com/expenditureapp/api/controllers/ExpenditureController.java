package com.expenditureapp.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.expenditureapp.api.dtos.AddRequest;
import com.expenditureapp.api.services.ExpenditureService;

@RestController
@RequestMapping("/")
public class ExpenditureController {
	
	@Autowired
	ExpenditureService expenditureService;
	
	@PostMapping(path = "/add")
	public ResponseEntity<Object> expenditureAdd(@RequestBody AddRequest addRequest) {
		return expenditureService.addExpenditure(addRequest);
	}
	
	@GetMapping(path = "test")
	public String greet(){
		return "Running...";
	}
	
	@GetMapping(path = "/getexpenditure")
	public ResponseEntity<Object> expenditureGet(){
		return expenditureService.getExpenditure();
	}

}
