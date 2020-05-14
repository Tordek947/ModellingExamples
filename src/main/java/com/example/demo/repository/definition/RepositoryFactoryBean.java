package com.example.demo.repository.definition;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import com.example.demo.entity.composition.CompositeElement;
import com.example.demo.repository.definition.impl.DefaultCompositeElementRepository;

public class RepositoryFactoryBean<R extends JpaRepository<T, I>, T, I extends Serializable>
	extends JpaRepositoryFactoryBean<R, T, I> {

    public RepositoryFactoryBean(Class<? extends R> repositoryInterface) {
	super(repositoryInterface);
    }

    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
	return new RepositoryFactory<>(entityManager);
    }

    private static class RepositoryFactory<T, I extends Serializable> extends JpaRepositoryFactory {

	public RepositoryFactory(EntityManager entityManager) {
	    super(entityManager);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected JpaRepositoryImplementation<?, ?> getTargetRepository(RepositoryInformation information,
		EntityManager entityManager) {
	    if (CompositeElement.class.isAssignableFrom(information.getDomainType())) {
		return new DefaultCompositeElementRepository(information.getDomainType(), entityManager);
	    }
	    return super.getTargetRepository(information, entityManager);
	}

	@Override
	protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
	    if (CompositeElement.class.isAssignableFrom(metadata.getDomainType())) {
		return DefaultCompositeElementRepository.class;
	    }
	    return super.getRepositoryBaseClass(metadata);
	}
//	protected Object getTargetRepository(RepositoryMetadata metadata) {
//	    if (CompositeElement.class.isAssignableFrom(metadata.getDomainType()) {
//		return new DefaultCompositeElementRepository<>(metadata.getDomainType(), em);
//	    }
////	    return new MyRepositoryImpl<T, I>((Class<T>) metadata.getDomainClass(), entityManager);
//	}
//
//	protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
//
//	    // The RepositoryMetadata can be safely ignored, it is used by the
//	    // JpaRepositoryFactory
//	    // to check for QueryDslJpaRepository's which is out of scope.
//	    return MyRepository.class;
//	}
    }

}
