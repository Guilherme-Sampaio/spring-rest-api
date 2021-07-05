package project.guilherme.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import project.guilherme.model.ProjectModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import project.guilherme.repository.ProjectRepository;

@Controller
public class ProjectController {
    private ProjectRepository projectRepository;

    @Autowired
    public ProjectController(final ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping(path = "/projects")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Iterable<ProjectModel> getAllProjects() {
        return projectRepository.findAll();
    }

    @GetMapping(path = "/projects/user/{id}")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_DEV')")
    public Iterable<ProjectModel> getProjects(@PathVariable Long id) {
        return projectRepository.findByUserId(id);
    }
}
