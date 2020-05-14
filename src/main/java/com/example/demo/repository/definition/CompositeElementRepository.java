package com.example.demo.repository.definition;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.util.Assert;

import com.example.demo.entity.composition.CompositeElement;

@NoRepositoryBean
public interface CompositeElementRepository<T extends CompositeElement> extends CrudRepository<T, Long> {

    @Transactional
    @Override
    default void delete(T entity) {
	Assert.notNull(entity, "Entity must not be null!");

	if (entity.isNew()) {
	    return;
	}

	Optional<T> existing = findById(entity.getPk());

	// if the entity to be deleted doesn't exist, delete is a NOOP
	if (!existing.isPresent()) {
	    return;
	}
	if (existing.get().getCompositeParent() == null && entity.getCompositeParent() == null) {
	    mergeIfNeededAndRemoveEntity(entity);
	} else {
	    throw new IllegalStateException("Entity cannot be deleted while it belongs to a composite parent");
	}

    }

    void mergeIfNeededAndRemoveEntity(T entity);

    @Override
    default void deleteById(Long id) {
	Optional<T> existing = findById(id);

	// if the entity to be deleted doesn't exist, delete is a NOOP
	if (!existing.isPresent()) {
	    return;
	}
	T existingEntity = existing.get();
	if (existingEntity.getCompositeParent() == null) {
	    removeEntity(existingEntity);
	} else {
	    throw new IllegalStateException("Entity cannot be deleted while it belongs to a composite parent");
	}
    }

    void removeEntity(T entity);

    @Transactional
    @Override
    default void deleteAll() {
	Iterable<T> allEntities = findAll();
	for (T entity : allEntities) {
	    if (entity.getCompositeParent() != null) {
		throw new IllegalStateException("At least one entity contain composite parent!");
	    }
	}
	removeEntities(allEntities);
    }

    void removeEntities(Iterable<T> entities);

    @Override
    default void deleteAll(Iterable<? extends T> entities) {
	List<T> existingEntities = new LinkedList<>();
	for (T entity : entities) {
	    Assert.notNull(entity, "Entity must not be null!");

	    if (entity.isNew()) {
		continue;
	    }

	    Optional<T> existing = findById(entity.getPk());

	    // if the entity to be deleted doesn't exist, delete is a NOOP
	    if (!existing.isPresent()) {
		continue;
	    }
	    if (existing.get().getCompositeParent() != null || entity.getCompositeParent() != null) {
		throw new IllegalStateException("At least one entity contain composite parent!");
	    }
	    existingEntities.add(entity);
	}
	mergeIfNeededAndRemoveEntities(existingEntities);
    }

    void mergeIfNeededAndRemoveEntities(List<T> entities);

}
