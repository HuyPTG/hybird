package com.training.hyrid.dao;

import com.training.hyrid.entities.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPositionDAO extends JpaRepository<Position,Integer> {

}
