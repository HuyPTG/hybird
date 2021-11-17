package com.training.hyrid.service;

import com.training.hyrid.dao.IRoleDAO;
import com.training.hyrid.dao.IUserDAO;
import com.training.hyrid.entities.Role;
import com.training.hyrid.entities.User;
import com.training.hyrid.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService implements IUserService{

    @Autowired
    private IUserDAO iUserDAO;

    @Autowired
    private IRoleDAO iRoleDAO;

    @Override
    public List<User> listAllUser() {

        return iUserDAO.findAll();
    }

    public User findEmail(String email){
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
    public void addRoleToUser(String email, String roleName) {
        log.info("Saving new role {} to the database",roleName,email);
        User user = iUserDAO.findByEmail(email);
        Role role = iRoleDAO.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUserByEmail(String email) {
        return iUserDAO.findByEmail(email);
    }

    @Override
    public User getUserById(Integer id) {
        return iUserDAO.findById(id).get();
    }

    /*@Override
    public User update(Integer id, User userRequest) {
        User user = iUserDAO.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not exitst with id: " + id));
        user.setEmail(userRequest.getEmail());
        user.isStatusUserAccount(userRequest.isStatusUserAccount());
        return iUserDAO.save(user);
    }*/
}
