package com.ideas2it.companymanagement.assetmanagement.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "asset")
@Getter
@Setter
public class AssetType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "asset_type")
    private String assetType;

    @OneToOne(mappedBy = "assetType")
    private AssetDetails assetDetails;
}

