package com.ideas2it.companymanagement.assetmanagement.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

