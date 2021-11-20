package com.training.hyrid.service;

import com.training.hyrid.dao.IDepartmentDAO;
import com.training.hyrid.entities.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DepartmentService implements IDeparmentService{

    @Autowired
    private IDepartmentDAO iDepartmentDAO;

    @Override
    public Department findDepartmentById(Integer id) {
        return iDepartmentDAO.findById(id).get();
    }
}
