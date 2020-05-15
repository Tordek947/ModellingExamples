package com.example.demo.repository.composition;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.example.demo.entity.composition.Mirror;

@RepositoryRestController
public interface MirrorRepository extends CrudRepository<Mirror, Long> {

}
