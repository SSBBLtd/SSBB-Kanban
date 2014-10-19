package com.ssbb.kanban.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.ssbb.kanban.data.Storable;

public abstract class DAOImpl<Entity extends Storable> {

	private EntityManager em;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

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

}
