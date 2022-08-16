package com.example.speechapplication.repository;

import com.example.speechapplication.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

 @Query(value = "SELECT * from speechdb.subject WHERE keyword = :keyword",
   nativeQuery = true)
 Subject findIfExist(String keyword);

}
