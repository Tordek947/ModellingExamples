package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.example.demo.entity.Author;

@RepositoryRestController
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
