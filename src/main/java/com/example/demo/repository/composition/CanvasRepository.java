package com.example.demo.repository.composition;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.example.demo.entity.composition.Canvas;
import com.example.demo.entity.composition.Image;

@RepositoryRestController
public interface CanvasRepository extends CrudRepository<Canvas, Long> {

    Canvas findByImage(Image image);
}
