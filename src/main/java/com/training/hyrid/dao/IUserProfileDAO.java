package com.training.hyrid.dao;

import com.training.hyrid.entities.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserProfileDAO extends JpaRepository<UserProfile,Integer> {

}
