package com.example.demo.repository.composition;

import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.example.demo.entity.composition.Image;
import com.example.demo.repository.definition.CompositeElementRepository;

@RepositoryRestController
public interface ImageRepository extends CompositeElementRepository<Image> {

}
