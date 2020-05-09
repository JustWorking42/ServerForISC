package com.example.serverfortest.domain;

import javax.persistence.*;

@Entity
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @Column(columnDefinition = "TEXT")
    private String results;

    private String type;
    private String date;

    public Test(){
    }
    public Test(String type, String date, String results) {
        this.type = type;
        this.date = date;
        this.results = results;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }
}
