package com.training.hyrid.dao;

import com.training.hyrid.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDAO extends JpaRepository<User,Integer> {
    User findByEmail(String email);

}
