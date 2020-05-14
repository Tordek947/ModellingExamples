package com.example.demo.repository.composition;

import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.example.demo.entity.composition.Wick;
import com.example.demo.repository.definition.CompositeElementRepository;

//@RepositoryRestController
public interface WickRepository extends CompositeElementRepository<Wick> {

}
