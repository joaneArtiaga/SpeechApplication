package com.example.speechapplication.controller;

import com.example.speechapplication.dto.SpeechDto;
import com.example.speechapplication.model.Speech;
import com.example.speechapplication.repository.SpeechRepository;
import com.example.speechapplication.service.impl.SpeechServiceImpl;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class SpeechController {
    @Autowired
    SpeechRepository speechRepository;

    @Autowired
    SpeechServiceImpl speechService;

    @Autowired
    private ModelMapper modelMapper;

    Logger logger = LoggerFactory.getLogger(SpeechController.class);

    @PostMapping("/speech")
    public ResponseEntity<SpeechDto> createSpeech(@RequestBody SpeechDto speechDto) {
        logger.info("Creating Speech...");
        Speech speechReq = modelMapper.map(speechDto, Speech.class);
        Speech speech = speechService.saveSpeech(speechReq);
        SpeechDto speechDtoResp = modelMapper.map(speech, SpeechDto.class);
        return new ResponseEntity<>(speechDtoResp,HttpStatus.CREATED);
    }

    @GetMapping("/speech/all")
    public ResponseEntity<List<SpeechDto>> getAllSpeech() {
        logger.info("Retrieving Speech...");
        return new ResponseEntity<>(speechService.getAllSpeech().stream().map(speech -> modelMapper.map(speech, SpeechDto.class)).collect(Collectors.toList()),
          HttpStatus.FOUND);
    }

    @GetMapping("/speech/dateRange/{start}/{end}")
    public ResponseEntity<List<SpeechDto>> findByDateRange(@PathVariable("start") Date start,
                                                        @PathVariable("end") Date end) {
        logger.info("Finding Speech by date range...");
        return new ResponseEntity<>(speechService.findByDateRange(start, end).stream()
          .map(speech -> modelMapper.map(speech, SpeechDto.class)).collect(Collectors.toList()), HttpStatus.FOUND);
    }

    @GetMapping("/speech/findByActualSpeech/{actualSpeech}")
    public ResponseEntity<List<SpeechDto>> findByActualSpeech(@PathVariable("actualSpeech") String actualSpeech) {
        logger.info("Finding Speech by actual speech...");
        return new ResponseEntity<>(speechService.findByActualSpeech(actualSpeech).stream()
          .map(speech -> modelMapper.map(speech, SpeechDto.class)).collect(Collectors.toList()), HttpStatus.FOUND);
    }

    @GetMapping("/speech/findBySubject/{subject}")
    public ResponseEntity<List<SpeechDto>> findBySubject(@PathVariable("subject") String subject) {
        logger.info("Finding Speech by subject...");
        return new ResponseEntity<>(speechService.findBySubject(subject).stream()
          .map(speech -> modelMapper.map(speech, SpeechDto.class)).collect(Collectors.toList()), HttpStatus.FOUND);
    }

    @GetMapping("/speech/findAuthor/{firstname}/{lastname}")
    public ResponseEntity<List<SpeechDto>> findByAuthor(@PathVariable("firstname") String firstname,
                                       @PathVariable("lastname") String lastname) {
        logger.info("Finding Speech by author...");
        return new ResponseEntity<>(speechService.findByAuthor(firstname, lastname).stream()
          .map(speech -> modelMapper.map(speech, SpeechDto.class)).collect(Collectors.toList()),
          HttpStatus.FOUND);
    }

    @DeleteMapping("/speech/{id}")
    public ResponseEntity deleteSpeech(@PathVariable("id") long id) {
        logger.info("Deleting Speech...");
        if(speechService.deleteSpeech(id)){
            return new ResponseEntity<>("Speech with id "+id+" has been deleted.", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Speech with id "+id+" has not been deleted successfully.",
              HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/speech/{id}")
    public ResponseEntity<SpeechDto> updateSpeech(@PathVariable("id") long id,
                                       @RequestBody SpeechDto speechDto) {
        logger.info("Updating Speech...");
        Speech speechReq = modelMapper.map(speechDto, Speech.class);
        Speech speech = speechService.updateSpeech(id, speechReq);
        SpeechDto speechDtoResp = modelMapper.map(speech, SpeechDto.class);
        return new ResponseEntity<>(speechDtoResp, HttpStatus.OK);
    }
}
