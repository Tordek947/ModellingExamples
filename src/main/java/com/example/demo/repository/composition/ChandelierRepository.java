package com.example.demo.repository.composition;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.example.demo.entity.composition.Chandelier;

@RepositoryRestController
public interface ChandelierRepository extends CrudRepository<Chandelier, Long> {

}
