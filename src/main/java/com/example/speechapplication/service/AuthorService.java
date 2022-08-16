package com.example.speechapplication.service;

import com.example.speechapplication.model.Author;

import java.util.Set;

public interface AuthorService {
    public Set<Author> saveAuthors(Set<Author> setOfAuthor);
    public Author checkAuthorExist(Author author);
}
