package com.ssbb.kanban.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(value = "/home")
	public String loadHome() {
		return "home";
	}

	@RequestMapping(value = "/trial2")
	public String trailPage() {
		return "trial2";
	}

}
