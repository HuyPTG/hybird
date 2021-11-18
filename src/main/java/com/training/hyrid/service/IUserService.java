package com.training.hyrid.service;

import com.training.hyrid.entities.Role;
import com.training.hyrid.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    public List<User> listAllUser();

    User saveUser(User user);

    Role saveRole(Role role);

    Optional<User> getUserByEmail(String email);

    User getUserById(Integer id);


}
