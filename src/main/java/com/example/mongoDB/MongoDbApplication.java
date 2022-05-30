package com.example.mongoDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongoDbApplication {

	public static void main(String[] args) {

		SpringApplication.run(MongoDbApplication.class, args);
		System.out.println("Server is started");
	}

}
