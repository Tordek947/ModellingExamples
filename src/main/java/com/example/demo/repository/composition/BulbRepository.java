package com.example.demo.repository.composition;

import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.example.demo.entity.composition.Bulb;

import ua.cmathtutor.startledfrog.repository.composition.CompositeElementRepository;

@RepositoryRestController
public interface BulbRepository extends CompositeElementRepository<Bulb> {

}
