package com.training.hyrid.controller;

import com.training.hyrid.dto.PositionDTO;
import com.training.hyrid.dto.RoleDTO;
import com.training.hyrid.entities.Position;
import com.training.hyrid.entities.Role;
import com.training.hyrid.service.IRoleService;
import com.training.hyrid.service.RoleService;
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
@RequestMapping("/api")
public class RoleController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RoleService roleService;

    @GetMapping("/roles")
    public List<Role> listRole(){
        return roleService.listAllRole();
    }

    @GetMapping("/roles/{id}")
    public ResponseEntity<RoleDTO> getRoleById(@PathVariable(name = "id") Integer id){
        try{
            Role role = roleService.get(id);
            //convert entity to DTO
            RoleDTO roleResponse = modelMapper.map(role,RoleDTO.class);
            return ResponseEntity.ok().body(roleResponse);
        }catch (NoSuchElementException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/roles")
    public ResponseEntity<RoleDTO> addRole(@RequestBody RoleDTO roleDTO){

        //DTO to entity
        Role roleRequest = modelMapper.map(roleDTO,Role.class);
        Role role = roleService.save(roleRequest);
        //entity to DTO
        RoleDTO roleResponse = modelMapper.map(role,RoleDTO.class);

        return new ResponseEntity<RoleDTO>(roleResponse,HttpStatus.CREATED);
    }

    @PutMapping("/roles/{id}")
    public ResponseEntity<RoleDTO> updateRoleById(@RequestBody RoleDTO roleDTO,
                                                          @PathVariable Integer id){
        //DTO to entity
        Role roleRequest = modelMapper.map(roleDTO,Role.class);
        Role role = roleService.update(id,roleRequest);
        //entity to DTO
        RoleDTO roleResponse = modelMapper.map(role,RoleDTO.class);
        return ResponseEntity.ok().body(roleResponse);
    }

    @DeleteMapping("/roles/{id}")
    public String deleteRoleById(@PathVariable(value = "id") Integer id){
        roleService.delete(id);
        return "Deleted succesully id = " + id;
    }

}
