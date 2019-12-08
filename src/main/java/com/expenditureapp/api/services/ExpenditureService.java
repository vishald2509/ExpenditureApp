package com.expenditureapp.api.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.expenditureapp.api.dtos.AddRequest;
import com.expenditureapp.api.models.Expenditure;
import com.expenditureapp.api.repositories.ExpenditureRepository;

@Service
public class ExpenditureService {
	
	@Autowired
	ExpenditureRepository expenditureRepository;
	
	public ResponseEntity<Object> addExpenditure(AddRequest addRequest) {
		// TODO Auto-generated method stub
		String id = UUID.randomUUID().toString(); // Gennerate UUID
		Expenditure expenditure = new Expenditure(id, addRequest.getExpenditureName(), addRequest.getPrice());
		expenditureRepository.save(expenditure);
		return new ResponseEntity<Object>(expenditure, HttpStatus.OK);
	}

	public ResponseEntity<Object> getExpenditure() {
		// TODO Auto-generated method stub
		List<Expenditure> expenditureList = expenditureRepository.findAll();
		return new ResponseEntity<Object>(expenditureList, HttpStatus.OK);
	}

}
