package com.training.hyrid.controller;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api")
public class RoleController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IRoleService iRoleService;

    @GetMapping("/roles")
    public List<Role> listRole(){
        return iRoleService.listAllRole();
    }

    @GetMapping("/roles/{id}")
    public ResponseEntity<RoleDTO> getRoleById(@PathVariable(name = "id") Integer id){
        try{
            Role role = iRoleService.get(id);
            //convert entity to DTO
            RoleDTO roleResponse = modelMapper.map(role,RoleDTO.class);
            return ResponseEntity.ok().body(roleResponse);
        }catch (NoSuchElementException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }



}
