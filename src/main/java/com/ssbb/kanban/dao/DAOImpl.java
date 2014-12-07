package com.ssbb.kanban.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ssbb.kanban.data.Storable;

/**
 * This class contains methods for basic CRUD (Create, Read, Update, Delete)
 * operations for all data objects. All object specific DAOs will extend this
 * class.
 * 
 * @author Ilya Skliarov, Raymond Tong
 *
 * @param <Entity>
 *            The object on which a CRUD operation is performed
 */
public class DAOImpl<Entity extends Storable> {

	@Autowired
	@PersistenceContext
	protected EntityManager em;

	@Transactional
	public void add(Entity entity) {
		em.persist(entity);
	}

	@Transactional
	public void remove(Entity entity) {
		em.remove(em.merge(entity));
	}

	@Transactional
	public void update(Entity entity) {
		em.merge(entity);
	}

	public Entity getById(Class<Entity> className, int id) {
		Entity entity = em.find(className, id);
		return entity;
	}

	@SuppressWarnings("rawtypes")
	public List getAll(Class className) {
		Query q = em.createNativeQuery(
				"select * from " + className.getSimpleName(), className);
		return q.getResultList();
	}
}
