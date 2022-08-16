package com.example.speechapplication.service;

import com.example.speechapplication.model.Speech;

import java.sql.Date;
import java.util.List;

public interface SpeechService {
    public Speech saveSpeech(Speech speech);
    public List<Speech> getAllSpeech();
    public List<Speech> findByDateRange(Date start,Date end);
    public List<Speech> findByActualSpeech(String actualSpeech);
    public List<Speech> findBySubject(String subject);
    public List<Speech> findByAuthor(String firstname,String lastname);
    public Boolean deleteSpeech(long id);
    public Speech updateSpeech(long id,Speech speech);
}
