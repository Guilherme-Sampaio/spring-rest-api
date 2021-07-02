package project.guilherme.controller;

import project.guilherme.entities.ProjectModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.guilherme.repository.ProjectRepository;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    ProjectRepository projectRepository;

    @GetMapping()
    public ResponseEntity<ProjectModel> getProject(Long id) {
        try {
            ProjectModel project = projectRepository.getById(id);
            return project == null ? new ResponseEntity<>(project, HttpStatus.OK)
                    : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception error) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<ProjectModel>> getProjects() {
        try {
            List<ProjectModel> projects = projectRepository.findAll();
            return projects.isEmpty() ? new ResponseEntity<>(projects, HttpStatus.OK)
                    : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception error) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
