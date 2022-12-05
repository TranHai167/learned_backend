package com.example.libraryservice.service;

import com.example.libraryservice.model.Book;
import java.util.List;

public interface LibraryService {
    List<Book> getAllBooks();

    void removeBookByTitle(String title);

    Book findBookByTitle(String title);

    void reduceBookByOne(String title, int number);
}
