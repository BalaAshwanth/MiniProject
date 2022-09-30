package com.ideas2it.companymanagement.seatmanagement.repository;

import com.ideas2it.companymanagement.seatmanagement.entity.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation, Integer> {
}
