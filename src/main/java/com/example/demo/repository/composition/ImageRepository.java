package com.example.demo.repository.composition;

import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.example.demo.entity.composition.Image;

import ua.cmathtutor.startledfrog.repository.composition.CompositeElementRepository;

@RepositoryRestController
public interface ImageRepository extends CompositeElementRepository<Image> {

}
