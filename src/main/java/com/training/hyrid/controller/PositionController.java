package com.training.hyrid.controller;

import com.training.hyrid.entities.Position;
import com.training.hyrid.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @GetMapping(value = "/positions")
    public List<Position>  list(){
        return positionService.listAllPosition();
    }

    @GetMapping("/positions/{id}")
    public ResponseEntity<Position> getPositionById(@PathVariable Integer id){
        try {
            Position position = positionService.get(id);
            return new ResponseEntity<Position>(position, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<Position>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/positions")
    public Position addPosition(@RequestBody Position position){
        positionService.save(position);
        return position;
    }

    @PutMapping("/positions/{id}")
    public ResponseEntity<Position> updatePositionById(@RequestBody Position position,
                       @PathVariable Integer id){
       Position position1 = positionService.update(id,position);
       return ResponseEntity.ok().body(position1);
    }

    @DeleteMapping("/positions/{id}")
    public String deletePositionById(@PathVariable(value = "id") Integer id){
      positionService.delete(id);
      return "Deleted succesully id = " + id;
    }
}
