package com.training.hyrid.api;

import com.training.hyrid.entities.UserProfile;
import com.training.hyrid.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
@RequestMapping("/api/update_profile")
public class UserProfileController {

    private static final long serialVersionUID = 1L;

    @Autowired
    private UserProfileService userProfileService;

    @GetMapping("/get/{id}")
    public UserProfile findUserProfile(@PathVariable(name = "id") Integer id) throws Exception{

        return userProfileService.getUserProfile(id);
    }

}
