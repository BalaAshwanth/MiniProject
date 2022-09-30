package com.ideas2it.companymanagement.assetmanagement.entity;

import com.ideas2it.companymanagement.employeemanagement.entity.Employee;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "asset_details")
@Setter
@Getter
public class AssetDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "asset_name")
    private String assetName;

    @Column(name = "serial_number")
    private String serialNumber;

    @OneToOne
    @JoinColumn(name = "asset_id", referencedColumnName = "id")
    private AssetType assetType;

    @OneToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

}
