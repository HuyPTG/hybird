package com.training.hyrid.controller;

import com.training.hyrid.dto.RoleDTO;
import com.training.hyrid.dto.UserDTO;
import com.training.hyrid.entities.Role;
import com.training.hyrid.entities.User;
import com.training.hyrid.exception.ResourceNotFoundException;
import com.training.hyrid.service.RoleService;
import com.training.hyrid.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


@Controller
@EnableAutoConfiguration
@RequestMapping("/api/admin")
public class UserController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/list-user")
    public List<User> listUser (){
        return userService.listAllUser();
    }

    @GetMapping("/get-user-by-id/{id}")
    public ResponseEntity<UserDTO> getRoleById(@PathVariable(name = "id") Integer id){
        try{
            User user = userService.get(id);
            //convert entity to DTO
            UserDTO userResponse = modelMapper.map(user,UserDTO.class);
            return ResponseEntity.ok().body(userResponse);
        }catch (NoSuchElementException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get-email/{email}")
    public ResponseEntity<UserDTO> getEmail(@PathVariable(name = "email") String email){
        try{
            User user = userService.findEmail(email);
            //convert entity to DTO
            UserDTO userResponse = modelMapper.map(user,UserDTO.class);
            return ResponseEntity.ok().body(userResponse);
        }catch (NoSuchElementException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create-user")
    public ResponseEntity<UserDTO> addRole(@RequestBody UserDTO userDTO) throws NoSuchAlgorithmException {

        //DTO to entity

        Role role = new Role();
        User userRequest = modelMapper.map(userDTO,User.class);
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        userRequest.getPassword();
        userRequest.getEmail();



        System.out.println(userRequest.getPassword());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getRole());

        byte[] hash = digest.digest(userRequest.getPassword().getBytes(StandardCharsets.UTF_8));
        String hex = DatatypeConverter.printHexBinary(hash);
        System.out.println(hex);
        userRequest.setPassword(hex);
        /*if(userRequest.getEmail().equals(userService.findEmail(userService.listAllUser()))){
            return new ResponseEntity<UserDTO>(HttpStatus.OK);
        } else {

        }*/
        //convert entity to DTO
        User user = userService.save(userRequest);

        //entity to DTO
        UserDTO userResponse = modelMapper.map(user,UserDTO.class);
        return new ResponseEntity<UserDTO>(userResponse,HttpStatus.CREATED);
    }
}
