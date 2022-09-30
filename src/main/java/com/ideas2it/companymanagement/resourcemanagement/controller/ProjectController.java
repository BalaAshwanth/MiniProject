package com.ideas2it.companymanagement.resourcemanagement.controller;

import com.ideas2it.companymanagement.resourcemanagement.dto.ProjectDto;
import com.ideas2it.companymanagement.resourcemanagement.service.impl.ProjectServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    ProjectServiceImpl projectService;

    public ProjectController(ProjectServiceImpl projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<ProjectDto> getAllProjects() {
        return projectService.getAllProjectDetails();
    }

    @GetMapping(path = "/{projectId}")
    public ProjectDto getProject(@PathVariable("projectId") Integer projectId) {
        return projectService.getProjectDetails(projectId);
    }

    @PutMapping
    public ProjectDto updateProject(@RequestBody ProjectDto projectDto){
        return projectService.updateProjectDetails(projectDto);
    }

    @PostMapping
    public ProjectDto insertProject(@RequestBody ProjectDto projectDto){
        return projectService.insertProjectDetails(projectDto);
    }

    @DeleteMapping(path = "/{projectId")
    public boolean deleteProject(@PathVariable("projectId") Integer projectId){
        return projectService.deleteProjectDetails(projectId);
    }
}
