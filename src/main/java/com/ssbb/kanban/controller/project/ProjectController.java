package com.ssbb.kanban.controller.project;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssbb.kanban.Constants;
import com.ssbb.kanban.dao.impl.ProjectDAO;
import com.ssbb.kanban.data.impl.Project;

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

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "createProject", method = RequestMethod.POST)
	public String createProject(ModelMap map, HttpSession session,
			Project project) {
		ArrayList<Project> projectList = (ArrayList<Project>) session
				.getAttribute(Constants.PROJECT_LIST);

		if (null != projectList) {
			projectDAO.add(project);
			projectList.add(project);
		}

		return "redirect:/project";
	}

}
