package com.training.hyrid.api;

import com.training.hyrid.common.ERole;
import com.training.hyrid.dao.IRoleDAO;
import com.training.hyrid.dto.UserDTO;
import com.training.hyrid.entities.Role;
import com.training.hyrid.entities.User;
import com.training.hyrid.exception.ResourceNotFoundException;
import com.training.hyrid.exception.ResponseMessage;
import com.training.hyrid.service.RoleService;
import com.training.hyrid.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.*;


@Controller
@EnableAutoConfiguration
@RequestMapping("/api/admin")
public class UserController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;



    @Autowired
    private RoleService roleService;
    private IRoleDAO iRoleDAO;

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
            User user = userService.getUserById(id);
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
            Optional<User> user = userService.findEmail(email);
            //convert entity to DTO
            UserDTO userResponse = modelMapper.map(user,UserDTO.class);
            return ResponseEntity.ok().body(userResponse);
        }catch (NoSuchElementException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

   /* public ResponseEntity<RoleDTO> getName(String name){
        Role role = roleService
    }*/

    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) throws NoSuchAlgorithmException {

        //DTO to entity
/*        roleService.listAllRole();*/
/*        User userRequest = modelMapper.map(userDTO,User.class);*/
        if(userService.checkExistEmail(userDTO.getEmail())){
            return ResponseEntity.badRequest().body( new ResponseMessage("The Email is already exist",400L));
        }
        /*Set<String> stringRole = userDTO.getRole();*/
        String stringRole = userDTO.getRole();
/*        System.out.println(userDTO.getEmail());*/
/*        Timestamp createAt = userDTO.getCreatedAt();*/
        Set<Role> roles = new HashSet<>();

        if(stringRole == null){
            Role userRole = userService.findRoleName(ERole.USER).orElseThrow(() -> new ResourceNotFoundException("Role is not found"));
            roles.add(userRole);
        } else {

                switch (stringRole){
                    case "ADMIN" :
                        Role adminRole = userService.findRoleName(ERole.ADMIN).orElseThrow(() -> new ResourceNotFoundException("Role is not found"));
                        roles.add(adminRole);
                        break;
                    case "USER" :
                        Role userRole = userService.findRoleName(ERole.USER).orElseThrow(() -> new ResourceNotFoundException("Role is not found"));
                        roles.add(userRole);
                        break;
                    default:
                        return ResponseEntity.ok(new ResponseMessage("Please in put exactly Admin or user",400L));
                }

        }
        User users = new User(roles,
                userDTO.isStatusUserAccount(),
                userDTO.getEmail(),
                passwordEncoder.encode(userDTO.getPassword()),
                userDTO.getLoginToken(),
                userDTO.getCreatedAt(),
                userDTO.getUpdateAt());
        users.setRoles(roles);
        userService.saveUser(users);
        //entity to DTO
/*        UserDTO userResponse = modelMapper.map(user,UserDTO.class);*/

        return ResponseEntity.ok(new ResponseMessage("Succesfully",200L));
    }

}