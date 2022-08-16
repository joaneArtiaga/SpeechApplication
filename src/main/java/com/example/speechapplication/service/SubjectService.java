package com.example.speechapplication.service;

import com.example.speechapplication.model.Subject;

import java.util.Set;

public interface SubjectService {
    public Set<Subject> saveSubjects(Set<Subject> setOfSubj);
    public Subject checkSubjExist(String subj);
}
