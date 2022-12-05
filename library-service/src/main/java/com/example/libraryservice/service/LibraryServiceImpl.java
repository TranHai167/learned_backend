package com.example.libraryservice.service;

import com.example.libraryservice.model.Book;
import com.example.libraryservice.repository.LibraryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {
    private final LibraryRepo repo;

    @Autowired
    public LibraryServiceImpl(LibraryRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    @Override
    public void removeBookByTitle(String title) {
        repo.removeBookByTitle(title);
    }

    @Override
    public Book findBookByTitle(String title) {
        return repo.findBookByTitle(title);
    }

    @Override
    public void reduceBookByOne(String title, int number) {
        Book book = repo.findBookByTitle(title);
        book.setCount(number-1);
        repo.removeBookByTitle(title);
        repo.save(book);
    }
}
