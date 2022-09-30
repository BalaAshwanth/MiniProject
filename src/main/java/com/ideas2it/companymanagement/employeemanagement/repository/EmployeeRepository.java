package com.ideas2it.companymanagement.employeemanagement.repository;

import com.ideas2it.companymanagement.employeemanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
