package com.example.speechapplication.repository;

import com.example.speechapplication.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepository extends JpaRepository<Author, Long> {

 @Query(value = "SELECT * from speechdb.author WHERE firstname = :firstname AND lastname = :lastname",
   nativeQuery = true)
 Author findIfExist(String firstname, String lastname);

}
