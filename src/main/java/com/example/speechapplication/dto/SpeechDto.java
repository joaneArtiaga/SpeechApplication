package com.example.speechapplication.dto;

import com.example.speechapplication.model.Author;
import com.example.speechapplication.model.Subject;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Data
public class SpeechDto {
 private long id;
 private Date date;
 private String actual_speech;
 private Set<Subject> subjects;
 private Set<Author> authors;
}
