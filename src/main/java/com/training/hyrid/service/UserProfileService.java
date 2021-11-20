package com.training.hyrid.service;

import com.training.hyrid.dao.IUserDAO;
import com.training.hyrid.dao.IUserProfileDAO;
import com.training.hyrid.dto.UserProfileRequest;
import com.training.hyrid.entities.User;
import com.training.hyrid.entities.UserProfile;
import com.training.hyrid.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
@Transactional
public class UserProfileService implements IUserProfileService{

    @Autowired
    private IUserDAO iUserDAO;

    @Autowired
    private IUserProfileDAO iUserProfileDAO;

    @Override
    public Optional<User> getUserByEmail(String email) {
        return iUserDAO.findByEmail(email);
    }

   /* @Override
    public UserProfile update(Integer id, UserProfile userProfileRequest) {
        UserProfile userProfile = iUserProfileDAO.findById(id).orElseThrow(() -> new ResourceNotFoundException("Position not exist with id: " + id));
        userProfile.setBirthday(userProfileRequest.getBirthday());
        return iUserProfileDAO.save(userProfile);
    }*/

    @Override
    public UserProfile get(Integer id) {
        return iUserProfileDAO.findById(id).get();
    }


}
