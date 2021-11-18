package com.training.hyrid.dao;

import com.training.hyrid.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserDAO extends JpaRepository<User,Integer> {

    Optional<User>  findByEmail(String email);

    Boolean existsByEmail(String email);

}
