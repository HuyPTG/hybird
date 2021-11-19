package com.training.hyrid.service;

import com.training.hyrid.entities.UserProfile;

public interface IUserProfileService {

    UserProfile getUserByToken(Integer id);
    UserProfile update(Integer id , UserProfile userProfile);
}
