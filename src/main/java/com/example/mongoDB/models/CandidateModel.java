package com.example.mongoDB.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "candidates")
public class CandidateModel {

    @Id
    private String id;
    private String name;
    private Double exp;

    @Indexed(unique = true)
    private String email;

    public CandidateModel() {}

    public CandidateModel(String name, Double exp, String email) {
        this.name = name;
        this.exp = exp;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getExp() {
        return exp;
    }

    public void setExp(double exp) {
        this.exp = exp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
