package com.example.mongoDB.services;

import com.example.mongoDB.models.CandidateModel;
import com.example.mongoDB.repositories.ICandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CandidateService {

    @Autowired
    ICandidateRepository candidateRepository;

    public List<CandidateModel> getAllCandidates() {
        return candidateRepository.findAll();
    }
    public Optional<CandidateModel> getCandidate(String id) {
        return candidateRepository.findById(id);
    }

    public Optional<CandidateModel> searchByEmail(String candidateEmail) {
        return candidateRepository.findByEmail(candidateEmail);
    }

    public List<CandidateModel> searchByExp(Double expFrom, Double expTo) {
        List<CandidateModel> result = new ArrayList<>();
        if (expTo != null) result = candidateRepository.findByExpBetween(expFrom, expTo);
        else result = candidateRepository.findByExpGreaterThanEqual(expFrom);
        return  result;
    }
    public CandidateModel createCandidate(CandidateModel candidate) {
        return candidateRepository.save(candidate);
    }
    public CandidateModel updateCandidate(String candidateId, CandidateModel candidate) {
        var foundOptionalCandidate = candidateRepository.findById(candidateId);
        var foundCandidate = foundOptionalCandidate.get();
        foundCandidate.setName(candidate.getName());
        foundCandidate.setExp(candidate.getExp());
        foundCandidate.setEmail(candidate.getEmail());
        return candidateRepository.save(foundCandidate);
    }
    public boolean deleteCandidate(String candidateId) {
        try {
            candidateRepository.deleteById(candidateId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public String deleteAllCandidates() {
            candidateRepository.deleteAll();
            return "The candidates were removed";
        }
}
