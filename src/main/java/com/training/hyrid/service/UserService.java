package com.training.hyrid.service;

import com.training.hyrid.common.ERole;
import com.training.hyrid.dao.IRoleDAO;
import com.training.hyrid.dao.IUserDAO;
import com.training.hyrid.entities.Role;
import com.training.hyrid.entities.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    /*@Override
    public User update(Integer id, User userRequest) {
        User user = iUserDAO.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not exitst with id: " + id));
        user.setEmail(userRequest.getEmail());
        user.isStatusUserAccount(userRequest.isStatusUserAccount());
        return iUserDAO.save(user);
    }*/
}
