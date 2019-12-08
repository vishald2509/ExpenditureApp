package com.expenditureapp.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.expenditureapp.api.models.Expenditure;

public interface ExpenditureRepository extends MongoRepository<Expenditure, String>{

}
