package com.training.hyrid.api;

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

@RestController
@EnableAutoConfiguration
@RequestMapping("/api/positions")
public class PositionController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PositionService positionService;

    @GetMapping(value = "/")
    public List<Position>  list(){
        return positionService.listAllPosition();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PositionDTO> getPositionById(@PathVariable Integer id){
        try {
            Position position = positionService.get(id);
            //convert entity to DTO
            PositionDTO positionResponse = modelMapper.map(position,PositionDTO.class);
            return ResponseEntity.ok().body(positionResponse);
        } catch (NoSuchElementException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public Position addPosition(@RequestBody Position position){
        positionService.save(position);
        return position;
    }

    @PutMapping("/{id}")
    public ResponseEntity<PositionDTO> updatePositionById(@RequestBody PositionDTO positionDTO,
                                                          @PathVariable Integer id){
        //DTO to entity
        Position positionRequest = modelMapper.map(positionDTO,Position.class);
        Position position = positionService.update(id,positionRequest);
        //entity to DTO
        PositionDTO positionResponse = modelMapper.map(position,PositionDTO.class);
        return ResponseEntity.ok().body(positionResponse);
    }

    @DeleteMapping("/{id}")
    public String deletePositionById(@PathVariable(value = "id") Integer id){
      positionService.delete(id);
      return "Deleted succesully id = " + id;
    }
}
