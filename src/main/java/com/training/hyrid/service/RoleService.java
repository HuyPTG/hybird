package com.training.hyrid.service;

import com.training.hyrid.dao.IRoleDAO;
import com.training.hyrid.entities.Position;
import com.training.hyrid.entities.Role;
import com.training.hyrid.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RoleService implements IRoleService{

    @Autowired
    private IRoleDAO iRoleDAO;


    @Override
    public List<Role> listAllRole() {
        return (List<Role>) iRoleDAO.findAll();
    }

    @Override
    public Role save(Role role) {
        return iRoleDAO.save(role);
    }

    @Override
    public Role get(Integer id) {
        return iRoleDAO.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        iRoleDAO.deleteById(id);
    }

    @Override
    public Role update(Integer id, Role roleRequest) {
        Role role = iRoleDAO.findById(id).orElseThrow(() -> new ResourceNotFoundException("Role not exitst with id: " + id));
        role.setName(roleRequest.getName());
        role.setDescription(roleRequest.getDescription());
        return iRoleDAO.save(role);
    }
}
