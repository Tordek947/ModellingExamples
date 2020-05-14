package com.example.demo.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.example.demo.entity.Author;
import com.example.demo.entity.Book;

@RepositoryRestController
public interface BookRepository extends CrudRepository<Book, Long> {

    Collection<Book> findAllByAuthorsIn(Collection<Author> authors);
}
