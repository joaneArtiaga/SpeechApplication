package com.example.speechapplication.mapper.impl;

import com.example.speechapplication.dto.AuthorDto;
import com.example.speechapplication.dto.SpeechDto;
import com.example.speechapplication.dto.SubjectDto;
import com.example.speechapplication.exception.SpeechCustomException;
import com.example.speechapplication.mapper.SpeechMapper;
import com.example.speechapplication.model.Author;
import com.example.speechapplication.model.Speech;
import com.example.speechapplication.model.Subject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.annotation.processing.Generated;
import java.util.ArrayList;
import java.util.List;

@Generated(
  value = "org.mapstruct.ap.MappingProcessor",
  date = "2021-03-11T19:21:44+0100",
  comments = "version: 1.4.2.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
)
@Component
public class SpeechMapperImpl implements SpeechMapper {
    @Override
    public SpeechDto speechDto(Speech speech) {
        if(speech==null||speech.equals(new Speech())){
            throw new SpeechCustomException("Speech is empty or null", HttpStatus.INTERNAL_SERVER_ERROR.value());
        }else{
            SpeechDto speechDto = new SpeechDto();
            speechDto.setId(speech.getId());
            speechDto.setSubjects(speech.getSubjects());
            speechDto.setDate(speech.getDate());
            speechDto.setAuthors(speech.getAuthors());
            speechDto.setActual_speech(speech.getActual_speech());
            return speechDto;
        }
    }

    @Override
    public AuthorDto authorDto(Author author) {
        if(author==null||author.equals(new Author())){
            throw new SpeechCustomException("Author is empty or null",
              HttpStatus.INTERNAL_SERVER_ERROR.value());
        }else{
            AuthorDto authorDto = new AuthorDto();
            authorDto.setId(author.getId());
            authorDto.setFirstname(author.getFirstname());
            authorDto.setLastname(author.getLastname());
            return authorDto;
        }
    }

    @Override
    public SubjectDto subjectDto(Subject subject) {
        if(subject==null||subject.equals(new Subject())){
            throw new SpeechCustomException("Subject is empty or null",
              HttpStatus.INTERNAL_SERVER_ERROR.value());
        }else{
            SubjectDto subjectDto = new SubjectDto();
            subjectDto.setId(subjectDto.getId());
            subjectDto.setKeyword(subject.getKeyword());
            return subjectDto;
        }
    }

    @Override
    public List<SpeechDto> allSpeeches(List<Speech> speeches) {
        if(speeches.isEmpty()){
            throw new SpeechCustomException("Speeches list is empty or null",
              HttpStatus.INTERNAL_SERVER_ERROR.value());
        }else{
            List<SpeechDto> list = new ArrayList<SpeechDto>( speeches.size() );
            for ( Speech speech : speeches ) {
                list.add( speechDto(speech) );
            }
            return list;
        }
    }

    @Override
    public Speech dtoToSpeech(SpeechDto speechDto) {
        if(speechDto==null||speechDto.equals(new Speech())){
            throw new SpeechCustomException("Speech is empty or null", HttpStatus.INTERNAL_SERVER_ERROR.value());
        }else{
            Speech speech = new Speech();
            speech.setId(speechDto.getId());
            speech.setSubjects(speechDto.getSubjects());
            speech.setDate(speechDto.getDate());
            speech.setAuthors(speechDto.getAuthors());
            speech.setActual_speech(speechDto.getActual_speech());
            return speech;
        }
    }
}
