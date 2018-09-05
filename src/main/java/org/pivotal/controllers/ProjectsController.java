package org.pivotal.controllers;

import org.pivotal.models.Project;
import org.pivotal.services.ProjectsServices;
import org.pivotal.support.Message;
import org.pivotal.support.MessageManager;
import org.pivotal.support.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectsController {

    @Autowired
    private ProjectsServices projectService;

    @RequestMapping(method = RequestMethod.GET, value = Paths.PATH_PROJECTS)
    public ResponseEntity<?> getAllProjects() {
        return ResponseEntity.status(HttpStatus.OK).body(projectService.getAllProject());
    }

    @RequestMapping(method = RequestMethod.GET, value = Paths.PATH_PROJECTS_WITH_ID)
    public ResponseEntity<?> getProjectById(@PathVariable String id) {
        if (projectService.getProjectById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(MessageManager.entityDoesNotExist("user"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(projectService.getProjectById(id));
    }

    @RequestMapping(method = RequestMethod.POST, value = Paths.PATH_PROJECTS)
    public ResponseEntity<?> postProject(@RequestBody Project project) {
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.postProject(project));
    }

    @RequestMapping(method = RequestMethod.PUT, value = Paths.PATH_PROJECTS_WITH_ID)
    public ResponseEntity<?> updateProject(@RequestBody Project project, @PathVariable String id) {
        Message message = projectService.updateProject(project, id);
        if (message.getCode().equals("202")) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(message);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = Paths.PATH_PROJECTS_WITH_ID)
    public ResponseEntity<?> deleteProject(@PathVariable String id) {
        Message message = projectService.deleteProject(id);
        if (message.getCode().equals("200")) {
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

}
