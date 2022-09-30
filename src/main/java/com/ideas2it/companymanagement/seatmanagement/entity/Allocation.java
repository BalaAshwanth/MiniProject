package com.ideas2it.companymanagement.seatmanagement.entity;

import com.ideas2it.companymanagement.employeemanagement.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


/**
 * The persistent class for the allocation_details database table.
 */
@Entity
@Table(name = "allocation_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Allocation {

    @Id
    private int id;
    @Column(name = "seat_number")
    private String seatNumber;
    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}