package com.ssbb.kanban.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ssbb.kanban.dao.DAOImpl;
import com.ssbb.kanban.data.Storable;
import com.ssbb.kanban.data.impl.Project;
import com.ssbb.kanban.data.impl.Role;
import com.ssbb.kanban.data.impl.User;
import com.ssbb.kanban.utils.SQLHelper;

public class ProjectDAO extends DAOImpl<Storable> {

	@Autowired
	private RoleDAO roleDAO;

	private static String USER_PROJECT_ROLE_TABLE = "user_project_role";

	private static String ROLE_ID_COLUMN = "upr_role_ID";

	private static String PROJECT_ID_COLUMN = "upr_project_ID";

	private static String USER_ID_COLUMN = "upr_user_ID";
	

	/**
	 * Method to override and persist project and to add list of users and their
	 * roles to the USER_PROJECT_ROLE_TABLE link table.
	 * 
	 * @param project
	 */
	@Transactional
	public void add(Project project) {

		// Persist the project to the database.
		super.add(project);
		/*User user = project.getUserList().get(0);
		String userID = String.valueOf(user.getId());
		String projectID = String.valueOf(project.getId());
		
		String[] columns = {ROLE_ID_COLUMN, PROJECT_ID_COLUMN, USER_ID_COLUMN};
		String[] values = {"1", projectID, userID};
		
		String insertStatement = SQLHelper.formInsertStatement(USER_PROJECT_ROLE_TABLE, columns, values);
		Query q = em.createNativeQuery(insertStatement);
		q.executeUpdate();*/
		
		/*
		StringBuffer valuesToBeAdded = new StringBuffer();
		ArrayList<User> userList = (ArrayList<User>) project.getUserList();
		ArrayList<Role> listOfAllRoles = (ArrayList<Role>) roleDAO
				.getListOfAllRoles();
		Query q = null;

		// Loop through each user in the list of the projects and add them to
		// the USER_PROJECT_ROLE_TABLE
		for (int i = 0; i < userList.size(); i++) {
			valuesToBeAdded.append("(");
			valuesToBeAdded.append(userList.get(i).getId());
			valuesToBeAdded.append(",");
			valuesToBeAdded.append(project.getId());
			valuesToBeAdded.append(",");
			// TO DO update so that each role is specific to user, for now this
			// is just making everyone a reviewer apart from the first person.
			// This is assuming the first person in the list is the creator.
			if (i == 0) {
				valuesToBeAdded.append(listOfAllRoles.get(1).getId());
			} else {
				valuesToBeAdded.append(listOfAllRoles.get(3).getId());
			}
			valuesToBeAdded.append(")");
			if (i != userList.size() - 1) {
				valuesToBeAdded.append(",");
			}

		}

		q = em.createNativeQuery("insert into " + USER_PROJECT_ROLE_TABLE + "("
				+ USER_ID_COLUMN + ", " + PROJECT_ID_COLUMN + ", "
				+ ROLE_ID_COLUMN + ") values" + valuesToBeAdded.toString());
		q.executeUpdate();*/
	}

	/**
	 * Method retrieves a list of projects that the user has associated with
	 * them.
	 * 
	 * @param user
	 * @return ArrayList<Project>
	 */
	public List<Project> getProjectsByUser(User user) {

		int userID = user.getId();

		return new ArrayList<Project>();
	}
	
	@Transactional
	public void addProjectUser(Project project) {
		User user = project.getUserList().get(0);
		String userID = String.valueOf(user.getId());
		String projectID = String.valueOf(project.getId());
		
		String[] columns = {ROLE_ID_COLUMN, PROJECT_ID_COLUMN, USER_ID_COLUMN};
		String[] values = {"1", projectID, userID};
		
		String insertStatement = SQLHelper.formInsertStatement(USER_PROJECT_ROLE_TABLE, columns, values);
		Query q = em.createNativeQuery(insertStatement);
		q.executeUpdate();
	}

}
