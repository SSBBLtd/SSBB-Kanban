package com.ssbb.kanban.controller.project;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssbb.kanban.Constants;
import com.ssbb.kanban.dao.impl.TaskDAO;
import com.ssbb.kanban.data.impl.Project;
import com.ssbb.kanban.data.impl.Status;
import com.ssbb.kanban.data.impl.Task;
import com.ssbb.kanban.data.impl.User;

@Controller
public class TaskController {

	@Autowired
	private TaskDAO taskDAO;

	@RequestMapping(value = "createTask", method = RequestMethod.POST)
	public String createTask(HttpSession session, Task task) {

		// Using taskDAO to get all status as super class method is called. Can
		// not use DAOImpl on it's own as the multiple implementations of the
		// class means Spring can not find the one we are referring to.
		@SuppressWarnings("unchecked")
		List<Status> statuses = taskDAO.getAll(Status.class);

		// This is the default 'To Do' status, every new task will be in this
		// status.
		task.setStatus(statuses.get(0));

		// get the user and selected project from the session. Populate the task
		// with these details.
		User user = (User) session.getAttribute(Constants.USER);
		Project project = (Project) session.getAttribute(Constants.PROJECT);
		task.setProject(project);
		task.setUser(user);
		project.getTasks().add(task);

		// persist the task to the database.
		taskDAO.add(task);

		return "project";
	}

}
