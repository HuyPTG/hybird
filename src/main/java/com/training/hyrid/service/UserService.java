package com.training.hyrid.service;

import com.training.hyrid.dao.IUserDAO;
import com.training.hyrid.entities.User;
import com.training.hyrid.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserDAO iUserDAO;

    @Override
    public List<User> listAllUser() {
        return iUserDAO.findAll();
    }

    public User findEmail(String email){
        return  iUserDAO.findByEmail(email);
    }

    @Override
    public User save(User user) {
        return iUserDAO.save(user);
    }

    @Override
    public User get(Integer id) {
        return iUserDAO.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        iUserDAO.deleteById(id);
    }

    /*@Override
    public User update(Integer id, User userRequest) {
        User user = iUserDAO.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not exitst with id: " + id));
        user.setEmail(userRequest.getEmail());
        user.isStatusUserAccount(userRequest.isStatusUserAccount());
        return iUserDAO.save(user);
    }*/
}
