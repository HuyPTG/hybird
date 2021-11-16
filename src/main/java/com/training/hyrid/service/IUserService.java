package com.training.hyrid.service;

import com.training.hyrid.entities.Role;
import com.training.hyrid.entities.User;

import java.util.List;

public interface IUserService {
    public List<User> listAllUser();

    User save(User user);

    User get(Integer id);

    void delete(Integer id);

}
