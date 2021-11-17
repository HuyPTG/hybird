package com.training.hyrid.dao;

import com.training.hyrid.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleDAO extends JpaRepository<Role,Integer> {
    Role findByName(String name);
}
