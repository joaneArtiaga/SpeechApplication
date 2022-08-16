package com.example.speechapplication.mapper;

import com.example.speechapplication.dto.AuthorDto;
import com.example.speechapplication.dto.SpeechDto;
import com.example.speechapplication.dto.SubjectDto;
import com.example.speechapplication.model.Author;
import com.example.speechapplication.model.Speech;
import com.example.speechapplication.model.Subject;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SpeechMapper {
    SpeechDto speechDto(Speech speech);
    AuthorDto authorDto(Author author);
    SubjectDto subjectDto(Subject subject);
    List<SpeechDto> allSpeeches(List<Speech> speeches);
    Speech dtoToSpeech(SpeechDto speechDto);
}
