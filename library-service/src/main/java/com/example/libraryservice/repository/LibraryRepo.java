package com.example.libraryservice.repository;

import com.example.libraryservice.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepo extends MongoRepository<Book, String> {

    void removeBookByTitle(String title);

    Book findBookByTitle(String title);
}
