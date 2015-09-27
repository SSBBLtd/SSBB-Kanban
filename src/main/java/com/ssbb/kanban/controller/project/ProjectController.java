package com.ssbb.kanban.controller.project;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssbb.kanban.Constants;
import com.ssbb.kanban.dao.impl.ProjectDAO;
import com.ssbb.kanban.data.impl.Project;
import com.ssbb.kanban.data.impl.User;

@Controller
public class ProjectController {

	@Autowired
	private Project project;

	@Autowired
	private ProjectDAO projectDAO;

	@RequestMapping(value = "project", method = RequestMethod.GET)
	public String loadProject(ModelMap map, HttpSession session) {

		return "project";
	}

	@RequestMapping(value = "loadSelectedProject", method = RequestMethod.POST)
	public String loadSelectedProject(ModelMap map, HttpSession session,
			Project submittedProject) {

		User user = (User) session.getAttribute(Constants.USER);
		for (Project userProject : user.getProjects()) {
			if (userProject.getName().equals(submittedProject.getName())) {
				map.addAttribute(Constants.PROJECT, userProject);
			}
		}

		return loadProject(map, session);

	}

	@RequestMapping(value = "createProject", method = RequestMethod.POST)
	public String createProject(ModelMap map, HttpSession session,
			Project project) {

		// Add the user who create the project to the project's user list.
		User user = (User) session.getAttribute(Constants.USER);
		project.getUserList().add(user);

		// persist the project
		projectDAO.add(project);

		// add the project to the list of the user's projects.
		user.getProjects().add(project);

		map.addAttribute(Constants.PROJECT, project);

		return loadProject(map, session);
	}

}
