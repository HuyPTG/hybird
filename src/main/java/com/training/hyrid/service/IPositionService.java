package com.training.hyrid.service;

import com.training.hyrid.entities.Position;

import java.util.List;

public interface IPositionService {

    public List<Position> listAllPosition();

    Position save(Position position);

    Position findPositionById(Integer id);

    void delete(Integer id);

    Position update(Integer id , Position position);
}
