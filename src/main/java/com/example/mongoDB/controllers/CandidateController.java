package com.example.mongoDB.controllers;

import com.example.mongoDB.models.CandidateModel;
import com.example.mongoDB.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidates")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @GetMapping()
    public List<CandidateModel> getAllCandidates() {
        return candidateService.getAllCandidates();
    }

    @GetMapping("/{id}")
    public Optional<CandidateModel> getCandidate(@PathVariable("id") String candidateId) {
        return candidateService.getCandidate(candidateId);
    }

    @GetMapping("/searchByEmail")
    public CandidateModel searchByEmail(@RequestParam(name = "email") String email) {
        return  candidateService.searchByEmail(email)
                .orElseThrow( () -> new ResourceAccessException("The candidate wasn't found"));
    }

    @GetMapping("(searchByExp")
    public List<CandidateModel> searchByExp(@RequestParam(name = "expFrom") Double expFrom, @RequestParam(name = "expTo") Double expTo) {
        return candidateService.searchByExp(expFrom, expTo);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public CandidateModel createCandidate(@RequestBody CandidateModel candidate) {
        return candidateService.createCandidate(candidate);
    }

    @PutMapping("/{id}")
    public CandidateModel updateCandidate(@PathVariable("id") String candidateId, @RequestBody CandidateModel candidate) {
        return candidateService.updateCandidate(candidateId, candidate);
    }

    @DeleteMapping("/{id}")
    public String deleteCandidate(@PathVariable("id") String candidateId) {
        var response = candidateService.deleteCandidate(candidateId);
        if (response == true) return "The candidate was removed";
        else return "The candidate wasn't found";
    }

    @DeleteMapping()
    public String deleteAllCandidate() {
        return candidateService.deleteAllCandidates();
    }

}
