package com.training.hyrid.service;

import com.training.hyrid.entities.Role;

import java.util.List;

public interface IRoleService {

    public List<Role> listAllRole();

    Role save(Role role);

    Role get(Integer id);

    void delete(Integer id);

    Role update(Integer id, Role role);
}
