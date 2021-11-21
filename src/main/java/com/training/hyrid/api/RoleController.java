package com.training.hyrid.api;

import com.training.hyrid.entities.Role;
import com.training.hyrid.request.RoleRequest;
import com.training.hyrid.response.RoleResponse;
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
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RoleService roleService;

    @GetMapping("/")
    public List<Role> listRole(){
        return roleService.listAllRole();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleResponse> getRoleById(@PathVariable(name = "id") Integer id){
        try{
            Role role = roleService.get(id);
            //convert entity to RoleRequest
            RoleResponse roleResponse = modelMapper.map(role,RoleResponse.class);
            return ResponseEntity.ok().body(roleResponse);
        }catch (NoSuchElementException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<RoleRequest> addRole(@RequestBody RoleRequest roleRequest){

        //RoleRequest to entity
        Role roleRequestFromClient = modelMapper.map(roleRequest,Role.class);
        Role role = roleService.save(roleRequestFromClient);
        //entity to RoleRequest
        RoleRequest roleResponse = modelMapper.map(role,RoleRequest.class);

        return new ResponseEntity<RoleRequest>(roleResponse,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleRequest> updateRoleById(@RequestBody RoleRequest roleRequest,
                                                          @PathVariable Integer id){
        //RoleRequest to entity
        Role roleRequestFromClient = modelMapper.map(roleRequest,Role.class);
        Role role = roleService.update(id,roleRequestFromClient);
        //entity to RoleRequest
        RoleRequest roleResponse = modelMapper.map(role,RoleRequest.class);
        return ResponseEntity.ok().body(roleResponse);
    }

    @DeleteMapping("/{id}")
    public String deleteRoleById(@PathVariable(value = "id") Integer id){
        roleService.delete(id);
        return "Deleted succesully id = " + id;
    }

}
