package com.ideas2it.companymanagement.resourcemanagement.service.impl;

import com.ideas2it.companymanagement.resourcemanagement.dto.ProjectDto;
import com.ideas2it.companymanagement.resourcemanagement.entity.Project;
import com.ideas2it.companymanagement.resourcemanagement.helper.ProjectHelper;
import com.ideas2it.companymanagement.resourcemanagement.repo.ProjectRepo;
import com.ideas2it.companymanagement.resourcemanagement.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    ProjectRepo projectRepo;

    public ProjectServiceImpl(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }
    public ProjectDto getProjectDetails(int projectId) {
        return ProjectHelper.projectToProjectDto(projectRepo.findById(projectId).orElse(null));
    }

    public ProjectDto updateProjectDetails(ProjectDto projectDto) {
        return ProjectHelper.projectToProjectDto(projectRepo.save(ProjectHelper
                .projectDtoToProject(projectDto)));
    }

    public ProjectDto insertProjectDetails(ProjectDto projectDto) {
        return ProjectHelper.projectToProjectDto(projectRepo.save(ProjectHelper
                .projectDtoToProject(projectDto)));
    }

    public boolean deleteProjectDetails(int projectId) {
        if (projectRepo.existsById(projectId)) {
            projectRepo.deleteById(projectId);
            return true;
        }
        return false;
    }

    public List<ProjectDto> getAllProjectDetails() {
        List<Project> projects = projectRepo.findAll();
        List<ProjectDto> projectsDto = new ArrayList<>();
        for (Project presentProject : projects) {
            projectsDto.add(ProjectHelper.projectToProjectDto(presentProject));
        }
        return projectsDto;
    }
}
