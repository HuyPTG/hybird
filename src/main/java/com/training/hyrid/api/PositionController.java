package com.training.hyrid.api;

import com.training.hyrid.entities.Position;
import com.training.hyrid.request.PositionRequest;
import com.training.hyrid.response.PositionResponse;
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
    public ResponseEntity<PositionResponse> getPositionById(@PathVariable Integer id){
        try {
            Position position = positionService.findPositionById(id);
            //convert PositionResponse to DTO
            PositionResponse positionResponse = modelMapper.map(position,PositionResponse.class);
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
    public ResponseEntity<PositionRequest> updatePositionById(@RequestBody PositionRequest positionRequest,
                                                              @PathVariable Integer id){
        //PositionRequest to entity
        Position positionRequestFromClient = modelMapper.map(positionRequest,Position.class);
        Position position = positionService.update(id,positionRequestFromClient);
        //entity to PositionResquest
        PositionRequest positionResponse = modelMapper.map(position,PositionRequest.class);
        return ResponseEntity.ok().body(positionResponse);
    }

    @DeleteMapping("/{id}")
    public String deletePositionById(@PathVariable(value = "id") Integer id){
      positionService.delete(id);
      return "Deleted succesully id = " + id;
    }
}
