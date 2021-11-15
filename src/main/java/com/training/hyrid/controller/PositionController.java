package com.training.hyrid.controller;

import com.training.hyrid.dto.PositionDTO;
import com.training.hyrid.entities.Position;
import com.training.hyrid.service.PositionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api")
public class PositionController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PositionService positionService;

    @GetMapping(value = "/positions")
    public List<PositionDTO>  list(){
        return positionService.listAllPosition().stream().map(position -> modelMapper.map(position,PositionDTO.class)).collect(Collectors.toList());
    }

    @GetMapping("/positions/{id}")
    public ResponseEntity<PositionDTO> getPositionById(@PathVariable(name = "id") Integer id){
        try {
            Position position = positionService.get(id);
            //convert entity to DTO
            PositionDTO positionResponse = modelMapper.map(position,PositionDTO.class);
            return ResponseEntity.ok().body(positionResponse);
        } catch (NoSuchElementException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/positions")
    public ResponseEntity<PositionDTO> addPosition(@RequestBody PositionDTO positionDTO){
        //convert DTO to entity
        Position positionRequest = modelMapper.map(positionDTO,Position.class);

        Position position = positionService.save(positionRequest);

        //convert entity to DTO
        PositionDTO positionResponse = modelMapper.map(position,PositionDTO.class);

        return new ResponseEntity<PositionDTO>(positionResponse,HttpStatus.CREATED);
    }

    @PutMapping("/positions/{id}")
    public ResponseEntity<PositionDTO> updatePositionById(@RequestBody PositionDTO positionDTO,
                       @PathVariable Integer id){
        //DTO to entity
       Position positionRequest = modelMapper.map(positionDTO,Position.class);
       Position position = positionService.update(id,positionRequest);
       //entity to DTO
        PositionDTO positionResponse = modelMapper.map(position,PositionDTO.class);
       return ResponseEntity.ok().body(positionResponse);
    }

    @DeleteMapping("/positions/{id}")
    public String deletePositionById(@PathVariable(value = "id") Integer id){
      positionService.delete(id);
      return "Deleted succesully id = " + id;
    }
}
