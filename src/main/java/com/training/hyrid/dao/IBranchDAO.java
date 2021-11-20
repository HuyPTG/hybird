package com.training.hyrid.dao;

import com.training.hyrid.entities.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBranchDAO extends JpaRepository<Branch,Integer> {
}
