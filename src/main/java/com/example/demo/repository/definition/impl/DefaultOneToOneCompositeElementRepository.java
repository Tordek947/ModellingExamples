package com.example.demo.repository.definition.impl;

import javax.persistence.EntityManager;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.util.Assert;

import com.example.demo.entity.composition.OneToOneCompositeElement;
import com.example.demo.repository.definition.OneToOneCompositeElementRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultOneToOneCompositeElementRepository<T extends OneToOneCompositeElement>
	extends SimpleJpaRepository<T, Long>
	implements OneToOneCompositeElementRepository<T> {

    private EntityManager em;

    public DefaultOneToOneCompositeElementRepository(Class<T> domainClass, EntityManager em) {
	super(domainClass, em);
	this.em = em;
    }

    @Override
    public <S extends T> S save(S entity) {
	log.info("going to save an entity");
	Assert.notNull(entity, "Entity must not be null!");
	log.info("Refreshing the entity");
	em.refresh(entity);
	log.info("Entity was refreshed successfully, parent is {}", entity.getCompositeParent());
	if (entity.getCompositeParent() == null) {
	    throw new DataIntegrityViolationException(
		    "One-to-one composite element can not be persisted without its parent");
	}
	return super.save(entity);
    }

}
