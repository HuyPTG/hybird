package com.training.hyrid.service;

import com.training.hyrid.common.ERole;
import com.training.hyrid.dao.IRoleDAO;
import com.training.hyrid.dao.IUserDAO;
import com.training.hyrid.dto.UserRequest;
import com.training.hyrid.entities.Role;
import com.training.hyrid.entities.User;
import com.training.hyrid.exception.ResourceNotFoundException;
import com.training.hyrid.exception.ResponseMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService implements IUserService{

    @Autowired
    private IUserDAO iUserDAO;

    @Autowired
    private IRoleDAO iRoleDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<User> listAllUser() {

        return iUserDAO.findAll();
    }

    public Optional<User> findEmail(String email){
        return  iUserDAO.findByEmail(email);
    }

    @Override
    public User saveUser(User user) {
        return iUserDAO.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return iRoleDAO.save(role);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return iUserDAO.findByEmail(email);
    }

    public Boolean checkExistEmail(String email){
        return iUserDAO.existsByEmail(email);
    }

    public Optional<Role> findRoleName(ERole name) {
        return iRoleDAO.findOneByName(name);
    }

    @Override
    public User getUserById(Integer id) {
        return iUserDAO.findById(id).get();
    }

    public User createUser(UserRequest userRequest) {

        Set<String> stringRole = userRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if(stringRole == null){
            Role userRole = iRoleDAO.findOneByName(ERole.USER).orElseThrow(() -> new ResourceNotFoundException("Role is not found"));
            roles.add(userRole);
        } else {
            stringRole.forEach(role -> {
                switch (role){
                    case "ADMIN" :
                        Role adminRole = iRoleDAO.findOneByName(ERole.ADMIN).orElseThrow(() -> new ResourceNotFoundException("Role is not found"));
                        roles.add(adminRole);
                        break;
                    case "USER" :
                        Role userRole = iRoleDAO.findOneByName(ERole.USER).orElseThrow(() -> new ResourceNotFoundException("Role is not found"));
                        roles.add(userRole);
                        break;
                    default:
                        break;
                }
            });
        }
        User users = new User(roles,
                userRequest.isStatus(),
                userRequest.getEmail(),
                passwordEncoder.encode(userRequest.getPassword()),
                userRequest.getLoginToken(),
                userRequest.getCreatedAt(),
                userRequest.getUpdatedAt());
       users.setRoles(roles);
       return iUserDAO.save(users);
    }

    /*@Override
    public User update(Integer id, User userRequest) {
        User user = iUserDAO.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not exitst with id: " + id));
        user.setEmail(userRequest.getEmail());
        user.isStatusUserAccount(userRequest.isStatusUserAccount());
        return iUserDAO.save(user);
    }*/
}
