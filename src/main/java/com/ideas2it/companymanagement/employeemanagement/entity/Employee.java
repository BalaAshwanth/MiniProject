package com.ideas2it.companymanagement.employeemanagement.entity;

import com.ideas2it.companymanagement.assetmanagement.entity.AssetDetails;
import com.ideas2it.companymanagement.resourcemanagement.entity.Project;
import com.ideas2it.companymanagement.seatmanagement.entity.Allocation;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "employee_details")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column(name = "employee_id")
    private String employeeId;
    @Column(name = "employee_name")
    private String employeeName;
    @Column
    private String gender;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "phone_number")
    private Long phoneNumber;
    @Column(name = "email_id")
    private String emailId;
    @Column
    private String designation;
    @Column(name = "date_of_joining")
    private LocalDate dateOfJoining;
    @Column
    private int experience;
    @OneToOne(mappedBy = "employee")
    private Allocation seat;
    @OneToOne(mappedBy = "employee")
    private AssetDetails assetDetails;
    @ManyToMany(mappedBy = "employees")
    private Project project;
    @ManyToOne
    @JoinColumn(name = "role",referencedColumnName = "id")
    private Role role;
}
