package com.example.demo.repository.definition;

import java.util.Optional;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import com.example.demo.entity.composition.OneToOneCompositeElement;

@NoRepositoryBean
public interface OneToOneCompositeElementRepository<T extends OneToOneCompositeElement> extends Repository<T, Long> {

    <S extends T> S save(S entity);

    <S extends T> Iterable<S> saveAll(Iterable<S> entities);

    Optional<T> findById(Long id);

    boolean existsById(Long id);

    Iterable<T> findAll();

    Iterable<T> findAllById(Iterable<Long> ids);

    long count();
}
