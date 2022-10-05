package com.ideas2it.companymanagement.employeemanagement.entity;

import com.ideas2it.companymanagement.assetmanagement.entity.AssetDetails;
import com.ideas2it.companymanagement.resourcemanagement.entity.Project;
import com.ideas2it.companymanagement.seatmanagement.entity.Seat;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@RequiredArgsConstructor
@Table(name = "employee_details")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column(name = "employee_id")
    private String employeeId;
    @Column(name = "name")
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
    @Transient
    private int Age;
    @OneToOne(mappedBy = "employee")
    private Seat seat;
    @OneToMany(mappedBy = "employee")
    private List<AssetDetails> assetDetails = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private Project project;
    @ManyToOne
    @JoinColumn(name = "role", referencedColumnName = "id")
    private Role role;
}
