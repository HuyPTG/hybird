package com.training.hyrid.service;

import com.training.hyrid.common.TokenJwtUtils;
import com.training.hyrid.dao.IUserDAO;
import com.training.hyrid.dao.IUserProfileDAO;
import com.training.hyrid.request.UserProfileRequest;
import com.training.hyrid.entities.User;
import com.training.hyrid.entities.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
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

    @Autowired
    private TokenJwtUtils jwtUtils;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    public Optional<User> getUserByEmail(String email) {
        return iUserDAO.findByEmail(email);
    }

    @Override
    public UserProfile getUserProfile(Integer id) {
        return iUserProfileDAO.findById(id).get();
    }

    public User getIdByTokenFromUser(UserProfileRequest userProfileRequest) {
        if(userProfileRequest.getLoginToken() != null && jwtUtils.validateJwtToken(userProfileRequest.getLoginToken())) {
            String email = jwtUtils.getEmailFromJwtToken(userProfileRequest.getLoginToken());
            UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        }
        return null;
    }


}
