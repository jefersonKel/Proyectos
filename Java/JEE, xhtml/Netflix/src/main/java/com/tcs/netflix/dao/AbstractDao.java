package com.tcs.netflix.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;

@TransactionAttribute(TransactionAttributeType.REQUIRED)
public abstract class AbstractDao<T extends Serializable> implements Serializable {

	private static final long serialVersionUID = 563671548616400296L;
	private final Class<T> clazz;
	@Inject
	private EntityManager entityManager;

	public AbstractDao(Class<T> clazz) {
		this.clazz = clazz;
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public T bucar(Object id) {
		return entityManager.find(clazz, id);
	}

	public void borrar(T entidad) {
		entityManager.remove(entityManager.merge(entidad));
		entityManager.flush();
	}

	public T editar(T entidad) {
		T entidadLocal = entityManager.merge(entidad);
		entityManager.flush();
		return entidadLocal;
	}

	public void guardar(T entidad) {
		try {
			entityManager.persist(entidad);
		} catch (Exception e) {
			e.getMessage();
		}
		
	}

	public List<T> buscarTodos() {
		final CriteriaQuery<T> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(clazz);
		criteriaQuery.select(criteriaQuery.from(clazz));
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

	public void borrarTodos() {
		final CriteriaDelete<T> criteriaDelete = entityManager.getCriteriaBuilder().createCriteriaDelete(clazz);
		criteriaDelete.from(clazz);
		entityManager.createQuery(criteriaDelete).executeUpdate();
	}
}
