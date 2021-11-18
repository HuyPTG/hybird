package com.training.hyrid.dao;

import com.training.hyrid.common.ERole;
import com.training.hyrid.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleDAO extends JpaRepository<Role,Integer> {

    Optional<Role> findOneByName(ERole name);
}
