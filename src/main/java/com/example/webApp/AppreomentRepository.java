package com.example.webApp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppreomentRepository extends JpaRepository<Appreoment, String> {
    List<Appreoment> findByFullnameContainingIgnoreCase(String fullname);

    List<Appreoment> findByIctNumber(String ictNumber);

    List<Appreoment> findByUniversityCode(int universityCode);

    @Query("SELECT a FROM Appreoment a WHERE a.totalScore BETWEEN :min AND :max")
    List<Appreoment> findByScoreRange(int min, int max);
}
