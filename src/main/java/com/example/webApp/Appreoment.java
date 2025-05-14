package com.example.webApp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "appreoments")
public class Appreoment {
    @Id
    private String ictNumber;
    private String fullname;
    private int totalScore;
    private int universityCode;

    // Default constructor for JPA
    public Appreoment() {}

    public Appreoment(String ictNumber, String fullname, int totalScore, int universityCode) {
        this.ictNumber = ictNumber;
        this.fullname = fullname;
        this.totalScore = totalScore;
        this.universityCode = universityCode;
    }

    // Getters and Setters
    public String getIctNumber() {
        return ictNumber;
    }

    public void setIctNumber(String ictNumber) {
        this.ictNumber = ictNumber;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getUniversityCode() {
        return universityCode;
    }

    public void setUniversityCode(int universityCode) {
        this.universityCode = universityCode;
    }
}
