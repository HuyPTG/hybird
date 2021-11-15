package com.training.hyrid.service;

import com.training.hyrid.dao.IPositionDAO;
import com.training.hyrid.entities.Position;
import com.training.hyrid.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PositionService implements IPositionService{

    @Autowired
    private IPositionDAO iPositionDAO;

    public PositionService(IPositionDAO iPositionDAO){
        this.iPositionDAO = iPositionDAO;
    }

    public List<Position> listAllPosition(){
        return (List<Position>) iPositionDAO.findAll();
    }

    public Position save(Position position){
        return iPositionDAO.save(position);
    }

    public Position get(Integer id){
        return iPositionDAO.findById(id).get();
    }

    public void delete(Integer id){
       iPositionDAO.deleteById(id);
    }

    @Override
    public Position update(Integer id, Position positionRequest) {
        Position position = iPositionDAO.findById(id).orElseThrow(() -> new ResourceNotFoundException("Position not exist with id: " + id));
        position.setPositionName(positionRequest.getPositionName());
        position.setDescription(positionRequest.getDescription());
        return iPositionDAO.save(position);
    }
}
