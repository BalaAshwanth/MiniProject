package com.ideas2it.companymanagement.resourcemanagement.helper;

import com.ideas2it.companymanagement.resourcemanagement.dto.ProjectDto;
import com.ideas2it.companymanagement.resourcemanagement.entity.Project;

public class ProjectHelper {

    public static ProjectDto projectToProjectDto(Project project) {
        if (project != null) {
            ProjectDto projectDto = new ProjectDto();
            projectDto.setProjectName(project.getProjectName());
            projectDto.setProjectDescription(project.getProjectDescription());
            //projectDto.setEmployee(project.getEmployee());
            //projectDto.setEmployees(project.getEmployees());
            return projectDto;
        }
        return null;
    }

    public static Project projectDtoToProject(ProjectDto projectDto) {
        if (projectDto != null) {
            Project project = new Project();
            project.setProjectName(projectDto.getProjectName());
            project.setProjectDescription(projectDto.getProjectDescription());
            //project.setEmployee(projectDto.getEmployee());
            //project.setEmployees(projectDto.getEmployees());
            return project;
        }
        return null;
    }
}
