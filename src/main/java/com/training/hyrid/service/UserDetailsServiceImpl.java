package com.training.hyrid.service;

import com.training.hyrid.common.ERole;
import com.training.hyrid.common.TokenJwtUtils;
import com.training.hyrid.dao.IRoleDAO;
import com.training.hyrid.dao.IUserDAO;
import com.training.hyrid.response.JwtResponse;
import com.training.hyrid.request.LoginRequest;
import com.training.hyrid.request.SignupRequest;
import com.training.hyrid.entities.Role;
import com.training.hyrid.entities.User;
import com.training.hyrid.exception.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    IUserDAO iUserDAO;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    IRoleDAO iRoleDAO;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    TokenJwtUtils jwtUtils;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User users = this.iUserDAO.findByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException("Email not found with email : "+email));
        return UserDetailsImpl.build(users);
    }

    @Transactional
    public  ResponseEntity<?> authenticateUser(@Validated @RequestBody LoginRequest loginRequest){
        if(!iUserDAO.existsByEmail(loginRequest.getEmail())){
            return ResponseEntity
                    .badRequest()
                    .body(new ResponseMessage(" Email is not already taken on DB!",401L));
        }else {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail()
                            , loginRequest.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateJwtToken(authentication);
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            List<String> roles = userDetails.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());
            System.out.println(jwtUtils.getEmailFromJwtToken(jwt));
            return ResponseEntity.ok(new JwtResponse(
                    jwt,
                    200L,
                    "Login successfully",
                    userDetails.getId(),
                    roles
            ));
        }
    }

    @Transactional
    public ResponseEntity<?> logoutUsser(@Validated @RequestBody LoginRequest loginRequest ){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail()
                        , loginRequest.getPassword())
        );
        String jwt = jwtUtils.generateJwtToken(authentication);
        if(jwtUtils.getEmailFromJwtToken(jwt).equals(authentication.getName())){
            ResponseEntity.ok(new ResponseMessage(authentication.getName(),200L));
        }
        return ResponseEntity.ok(new ResponseMessage(authentication.getName(),400L));
    }

    @Transactional
    public  ResponseEntity<?> registerUser(@Validated @RequestBody SignupRequest signupRequest) {
        if (iUserDAO.existsByEmail(signupRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new ResponseMessage(" Email is already taken!", 401L));
        }
        if (signupRequest.getStatus()) {
            int status = 1;
        } else {
            int status = 0;
        }
        Timestamp createdAt = signupRequest.getCreatedAt();

        Set<String> strRole = signupRequest.getRole();


        Set<Role> roles = new HashSet<>();

        if (strRole == null) {
            Role userRole = iRoleDAO.findOneByName(ERole.USER)
                    .orElseThrow(() -> new RuntimeException(" Role is not found."));
            roles.add(userRole);
        } else {
            strRole.forEach(role -> {
                switch (role) {
                    case "ADMIN":
                        Role adminRoles = iRoleDAO.findOneByName(ERole.ADMIN)
                                .orElseThrow(() -> new RuntimeException(" Role is not found."));
                        roles.add(adminRoles);
                        break;
                    case "USER":
                        Role userRole = iRoleDAO.findOneByName(ERole.USER)
                                .orElseThrow(() -> new RuntimeException(" Role is not found."));
                        roles.add(userRole);
                        break;
                    default:
                        ResponseEntity.ok(new ResponseMessage("Role is not found!", 400L));
                        break;
                }
            });
        }
        User users = new User(
                roles,
                signupRequest.getStatus(),
                signupRequest.getEmail(),
                passwordEncoder.encode(signupRequest.getPassword()),
                createdAt
        );
        users.setRoles(roles);
        iUserDAO.save(users);
        return ResponseEntity.ok(new ResponseMessage("User registered successfully!", 200L));
    }

}