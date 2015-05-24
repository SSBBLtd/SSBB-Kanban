package com.ssbb.kanban.dao.impl;

import java.util.List;

import com.ssbb.kanban.dao.DAOImpl;
import com.ssbb.kanban.data.Storable;
import com.ssbb.kanban.data.impl.Project;
import com.ssbb.kanban.data.impl.User;

public class ProjectDAO extends DAOImpl<Storable> {

	public List<Project> getProjectsByUser(User user) {

		int userID = user.getId();

		return null;
	}

}
