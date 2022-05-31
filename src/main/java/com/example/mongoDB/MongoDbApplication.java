package com.example.mongoDB;

import com.example.mongoDB.models.CandidateModel;
import com.example.mongoDB.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongoDbApplication implements CommandLineRunner {

	@Autowired
	CandidateService candidateService;

	public static void main(String[] args) {

		SpringApplication.run(MongoDbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Server is started");

		var createdCandidate = candidateService.createCandidate(new CandidateModel("Santiago", 100D, "salviega6@gmailcom"));
		System.out.println(createdCandidate);

	}
}
