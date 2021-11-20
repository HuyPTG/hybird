package com.training.hyrid.service;

import com.training.hyrid.dao.IBranchDAO;
import com.training.hyrid.entities.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BranchService implements IBranchService{

    @Autowired
    private IBranchDAO iBranchDAO;

    @Override
    public Branch findBranchById(Integer id) {
        return iBranchDAO.findById(id).get();
    }
}
