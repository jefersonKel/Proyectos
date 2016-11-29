package com.tcs.netflix.producer;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EntityManagerProducer {
	@Produces
	@PersistenceContext
	private EntityManager entityManager;

}
