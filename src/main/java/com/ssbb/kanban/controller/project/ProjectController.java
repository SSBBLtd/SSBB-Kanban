package com.ssbb.kanban.controller.project;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProjectController {

	@RequestMapping(value ="project", method = RequestMethod.GET)
	public String loadProject(ModelMap map, HttpSession session) {
		return "project";
	}
	
	@RequestMapping(value = "createProject", method = RequestMethod.POST)
	public String createProject(ModelMap map, HttpSession session) {
		return "redirect:/project";
	}
	
}
