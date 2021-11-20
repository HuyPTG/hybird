package com.training.hyrid.api;

import com.training.hyrid.dto.RoleDTO;
import com.training.hyrid.dto.UserProfileRequest;
import com.training.hyrid.entities.Role;
import com.training.hyrid.entities.UserProfile;
import com.training.hyrid.service.UserProfileService;
import com.training.hyrid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
@RequestMapping("/api/update_profile")
public class UserProfileController {

    private static final long serialVersionUID = 1L;

    @Autowired
    private UserProfileService userProfileService;

    /*@PutMapping("/{id}")
    public ResponseEntity<?> updateUserProfile(@RequestBody UserProfileRequest userProfileRequest, @PathVariable Integer id ){
        UserProfile userProfile = userProfileService.update(id,userProfileRequest);
        return ResponseEntity.ok().body(userProfile);
    }*/

    @GetMapping("/get/{id}")
    public UserProfile findUserProfile(@PathVariable(name = "id") Integer id) throws Exception{
        return userProfileService.get(id);
    }

}
