package com.ssbb.kanban.dao.impl;

import javax.persistence.Query;

import com.ssbb.kanban.dao.DAOImpl;
import com.ssbb.kanban.data.Storable;
import com.ssbb.kanban.data.impl.Project;

public class ProjectDAO extends DAOImpl<Storable> {

	private final static Class<Project> projectClass = Project.class;
	
	public Project getProjectByName(String name) {
		Query q = em.createNativeQuery(
				"SELECT * FROM PROJECTS WHERE NAME = :name", projectClass);
		q.setParameter("name", name);
		
		return (Project) q.getSingleResult();
	}

}
