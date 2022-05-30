package com.example.mongoDB.repositories;

import com.example.mongoDB.models.CandidateModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICandidateRepository extends MongoRepository<CandidateModel, String> {

    Optional<CandidateModel> findByEmail(String candidateEmail);

    List<CandidateModel> findByExpGreaterThanEqual(double exp);

    List<CandidateModel> findByExpBetween(double from, double to);
}
