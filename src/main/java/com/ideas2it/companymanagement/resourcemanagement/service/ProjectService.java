package com.ideas2it.companymanagement.resourcemanagement.service;

import com.ideas2it.companymanagement.resourcemanagement.dto.ProjectDto;

import java.util.List;

public interface ProjectService {

    ProjectDto getProjectDetails(int projectId);

    ProjectDto updateProjectDetails(ProjectDto projectDto);

    ProjectDto insertProjectDetails(ProjectDto projectDto);

    boolean deleteProjectDetails(int projectId);

    List<ProjectDto> getAllProjectDetails();
}
