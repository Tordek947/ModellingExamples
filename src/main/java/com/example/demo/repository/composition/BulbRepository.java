package com.example.demo.repository.composition;

import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.example.demo.entity.composition.Bulb;
import com.example.demo.repository.definition.CompositeElementRepository;

@RepositoryRestController
public interface BulbRepository extends CompositeElementRepository<Bulb> {

}
