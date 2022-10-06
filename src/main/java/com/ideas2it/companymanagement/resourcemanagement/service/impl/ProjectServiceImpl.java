package com.ideas2it.companymanagement.resourcemanagement.service.impl;

import com.ideas2it.companymanagement.resourcemanagement.dto.ProjectDto;
import com.ideas2it.companymanagement.resourcemanagement.entity.Project;
import com.ideas2it.companymanagement.resourcemanagement.helper.ProjectHelper;
import com.ideas2it.companymanagement.resourcemanagement.repo.ProjectRepo;
import com.ideas2it.companymanagement.resourcemanagement.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Implementation for handling all business logics of project model.
 * </p>
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    ProjectRepo projectRepo;

    public ProjectServiceImpl(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    /**
     * <p>
     * Retrieves project detail from repository by id.
     * </p>
     *
     * @param projectId
     * @return ProjectDto
     */
    public ProjectDto getProjectDetails(int projectId) {
        return ProjectHelper.projectToProjectDto(projectRepo.findById(projectId).orElse(null));
    }

    /**
     * <p>
     * This is to updates the project detail.
     * </p>
     *
     * @param projectDto
     * @return ProjectDto
     */
    public ProjectDto updateProjectDetails(ProjectDto projectDto) {
        return ProjectHelper.projectToProjectDto(projectRepo.save(ProjectHelper
                .projectDtoToProject(projectDto)));
    }

    /**
     * <p>
     * This method is used to set project detail dto objects to project detail.
     * </p>
     *
     * @param projectDto
     * @return ProjectDto
     */
    public ProjectDto insertProjectDetails(ProjectDto projectDto) {
        return ProjectHelper.projectToProjectDto(projectRepo.save(ProjectHelper
                .projectDtoToProject(projectDto)));
    }

    /**
     * <p>
     * Deletes project detail by id.
     * </p>
     *
     * @param projectId
     * @return boolean
     */
    public boolean deleteProjectDetails(int projectId) {
        if (projectRepo.existsById(projectId)) {
            projectRepo.deleteById(projectId);
            return true;
        }
        return false;
    }

    /**
     * <p>
     * Retrieves all project detail from the database.
     * </p>
     *
     * @return List<ProjectDto>
     */
    public List<ProjectDto> getAllProjectDetails() {
        List<Project> projects = projectRepo.findAll();
        List<ProjectDto> projectsDto = new ArrayList<>();
        for (Project presentProject : projects) {
            projectsDto.add(ProjectHelper.projectToProjectDto(presentProject));
        }
        return projectsDto;
    }
}
