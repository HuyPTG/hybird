package com.training.hyrid.service;

import com.training.hyrid.entities.Role;
import com.training.hyrid.entities.User;

import java.util.List;

public interface IUserService {
    public List<User> listAllUser();

    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String email,String roleName );

    User getUserByEmail(String email);

    User getUserById(Integer id);


}
