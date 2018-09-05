package org.pivotal.services;

import java.util.ArrayList;
import java.util.List;


import org.pivotal.models.Project;
import org.pivotal.support.Message;
import org.pivotal.support.MessageManager;
import org.springframework.stereotype.Service;

@Service
public class ProjectsServices {

    private static final String ENTITY = "project";

    private List<Project> projectList = new ArrayList<>();

    public List<Project> getAllProject() {
        return projectList;
    }

    public Project getProjectById(String id) {
        for (Project project : projectList) {
            if (project.getId().equals(id)) {
                return project;
            }
        }
        return null;
    }

    public Message postProject(Project project) {
        projectList.add(project);
        return MessageManager.createdSuccessfully(ENTITY);
    }

    public Message updateProject(Project project, String id) {
        for (Project currentProject : projectList) {
            if (currentProject.getId().equals(id)) {
                currentProject.setId(project.getId());
                currentProject.setName(project.getName());
                return MessageManager.updatedSuccessfully(ENTITY);
            }
        }
        return MessageManager.entityDoesNotExist(ENTITY);
    }

    public Message deleteProject(String id) {
        for (int i = 0; i < projectList.size(); i++) {
            if (projectList.get(i).getId().equals(id)) {
                projectList.remove(i);
                return MessageManager.deletedSuccessfully(ENTITY);
            }
        }
        return MessageManager.entityDoesNotExist(ENTITY);
    }
}
