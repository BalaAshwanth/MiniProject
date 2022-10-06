package com.ideas2it.companymanagement.resourcemanagement.controller;

import com.ideas2it.companymanagement.resourcemanagement.dto.ProjectDto;
import com.ideas2it.companymanagement.resourcemanagement.service.impl.ProjectServiceImpl;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * Controller that handles the CRUD Operations.
 * </p>
 */
@RestController
@RequestMapping("/project")
public class ProjectController {

    ProjectServiceImpl projectService;

    public ProjectController(ProjectServiceImpl projectService) {
        this.projectService = projectService;
    }

    /**
     * <p>
     * retrieves all project.
     * </p>
     *
     * @return List<ProjectDto>
     *
     */
    @GetMapping
    public List<ProjectDto> getAllProjects() {
        return projectService.getAllProjectDetails();
    }

    /**
     * <p>
     * Searches and retrieves project based on the given id
     * </p>
     *
     * @param projectId
     * @return ProjectDto
     *
     */
    @GetMapping(path = "/{projectId}")
    public ProjectDto getProject(@PathVariable("projectId") Integer projectId) {
        return projectService.getProjectDetails(projectId);
    }

    /**
     * <p>
     * Initiates the process of updating project.
     * </p>
     *
     * @param projectDto
     * @return ProjectDto
     */
    @PutMapping
    public ProjectDto updateProject(@RequestBody ProjectDto projectDto) {
        return projectService.updateProjectDetails(projectDto);
    }

    /**
     * <p>
     * Creates new project and sends to project service
     * </p>
     *
     * @param projectDto
     * @return ProjectDto
     */
    @PostMapping
    public ProjectDto insertProject(@RequestBody ProjectDto projectDto) {
        return projectService.insertProjectDetails(projectDto);
    }

    /**
     * <p>
     * Searches and deletes project based on the given id.
     * </p>
     *
     * @param projectId
     * @return boolean
     *
     */
    @DeleteMapping(path = "/{projectId}")
    public boolean deleteProject(@PathVariable("projectId") Integer projectId) {
        return projectService.deleteProjectDetails(projectId);
    }
}
