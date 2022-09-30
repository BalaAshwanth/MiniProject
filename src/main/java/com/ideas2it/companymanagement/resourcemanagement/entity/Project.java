package com.ideas2it.companymanagement.resourcemanagement.entity;


import com.ideas2it.companymanagement.employeemanagement.entity.Employee;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

/**
 * The persistent class for the project database table.
 *
 */
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="project_description")
    private String projectDescription;

    @Column(name="project_name")
    private String projectName;

    //bi-directional many-to-one association to EmployeeDetail
    @OneToOne
    @JoinColumn(name="manager_id")
    private Employee employee;

    //bi-directional many-to-one association to Resource
    @ManyToMany
    @JoinTable(name = "resource",
    joinColumns = {@JoinColumn(name = "project_id")},
    inverseJoinColumns = {@JoinColumn(name = "employee_id")})
    private List<Employee> employees = new ArrayList<Employee>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}