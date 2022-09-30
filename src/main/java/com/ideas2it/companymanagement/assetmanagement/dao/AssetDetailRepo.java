package com.ideas2it.companymanagement.assetmanagement.dao;

import com.ideas2it.companymanagement.assetmanagement.entity.AssetDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetDetailRepo extends JpaRepository<AssetDetails,Integer> {
}
