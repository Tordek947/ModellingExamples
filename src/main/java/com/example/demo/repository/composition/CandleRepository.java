package com.example.demo.repository.composition;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.example.demo.entity.composition.Candle;

//@RepositoryRestController
public interface CandleRepository extends CrudRepository<Candle, Long> {

}
