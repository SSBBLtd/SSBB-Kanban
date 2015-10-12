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
import com.ssbb.kanban.utils.UserHelper;

@Controller
public class ProjectController {

    @Autowired
    private Project project;

    @Autowired
    private ProjectDAO projectDAO;

    private final String PAGE_ID = "project";

    /**
     * This method is called when a user selects a project from their list of
     * projects. This will find the project selected and add it to model map to
     * be used by the front end to be used by the front end to display that
     * project page.
     * 
     * @param map
     * @param session
     * @param submittedProject
     * @return String Page ID to load
     */
    @RequestMapping(value = "loadSelectedProject", method = RequestMethod.POST)
    public String loadSelectedProject(ModelMap map, HttpSession session, Project submittedProject) {

        //get user from the session.
        User user = (User) session.getAttribute(Constants.USER);

        //get the project from the user's projects.
        Project projectSelected = UserHelper.getUserSelectProjectByName(user, submittedProject.getName());

        if (projectSelected == null) {
            //TO DO, must return some error/error page.
        }

        //add project to map to be displayed.
        map.addAttribute(Constants.PROJECT, projectSelected);

        return PAGE_ID;

    }

    /**
     * Method is called when a user selects to create a new project. This will
     * get the project created from the front end and persist it into the
     * database as well as add it to the user's list of projects. The project
     * created will then be added to the model map to be used by the front end
     * to display that project page.
     * 
     * @param map
     * @param session
     * @param project
     * @return String Page ID to load
     */
    @RequestMapping(value = "createProject", method = RequestMethod.POST)
    public String createProject(ModelMap map, HttpSession session, Project project) {

        // Add the user who create the project to the project's user list.
        User user = (User) session.getAttribute(Constants.USER);
        project.getUserList().add(user);

        // persist the project
        projectDAO.add(project);

        // add the project to the list of the user's projects.
        user.getProjects().add(project);

        map.addAttribute(Constants.PROJECT, project);

        return PAGE_ID;
    }

}
