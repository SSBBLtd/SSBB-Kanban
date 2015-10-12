package com.ssbb.kanban.utils;

import com.ssbb.kanban.data.impl.Project;
import com.ssbb.kanban.data.impl.User;

public class UserHelper {

    /**
     * Method to get the selected project by project name from the user's
     * projects. If the user's projects does not contain any project with the
     * same name, method returns null.
     * 
     * @param user
     * @param projectNameToFind
     * @return
     */
    public static Project getUserSelectProjectByName(User user, String projectNameToFind) {

        //loop through the user's projects
        for (Project userProject : user.getProjects()) {

            //if project name is the one we need, return it.
            if (userProject.getName().equals(projectNameToFind)) {
                return userProject;
            }
        }

        //if no matches found, return null.
        return null;

    }

}
