package com.ssbb.kanban.controller.project;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssbb.kanban.Constants;
import com.ssbb.kanban.dao.impl.TaskDAO;
import com.ssbb.kanban.data.impl.Status;
import com.ssbb.kanban.data.impl.Task;
import com.ssbb.kanban.data.impl.User;

@Controller
public class TaskController {

	@Autowired
	private TaskDAO taskDAO;

	// TODO Need to implement correctly, Get status DAO and get project
	// correctly from front end. This is just guessing we have the first
	// project...
	@RequestMapping(value = "createTask", method = RequestMethod.POST)
	public String createTask(ModelMap map, HttpSession session, Task task) {

		List<Status> statuses = taskDAO.getAll(Status.class);

		task.setStatus(statuses.get(0));
		User user = (User) session.getAttribute(Constants.USER);
		user.getProjects().get(0).getTasks().add(task);
		task.setProject(user.getProjects().get(0));

		task.setUser(user);

		taskDAO.add(task);
		map.addAttribute(Constants.PROJECT, user.getProjects().get(0));

		return "project";
	}

}
