package com.training.hyrid.service;

import com.training.hyrid.dto.UserProfileRequest;
import com.training.hyrid.entities.User;
import com.training.hyrid.entities.UserProfile;

import java.util.Optional;

public interface IUserProfileService {

    Optional<User> getUserByEmail(String email);

/*    UserProfile update(UserProfile userProfile);*/

    UserProfile get(Integer id);
}
