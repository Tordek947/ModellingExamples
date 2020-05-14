package com.example.demo.repository.definition.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.composition.CompositeElement;
import com.example.demo.repository.definition.CompositeElementRepository;

@Transactional(readOnly = true)
public class DefaultCompositeElementRepository<T extends CompositeElement> extends SimpleJpaRepository<T, Long>
	implements CompositeElementRepository<T> {

    public DefaultCompositeElementRepository(Class<T> domainClass, EntityManager em) {
	super(domainClass, em);
	this.em = em;
    }

    private EntityManager em;

    @Transactional
    @Override
    public void mergeIfNeededAndRemoveEntity(T entity) {
	em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    @Transactional
    @Override
    public void removeEntity(T entity) {
	em.remove(entity);
    }

    @Transactional
    @Override
    public void removeEntities(Iterable<T> entities) {
	entities.forEach(em::remove);
    }

    @Transactional
    @Override
    public void mergeIfNeededAndRemoveEntities(List<T> entities) {
	entities.forEach(this::mergeIfNeededAndRemoveEntity);
    }

}
