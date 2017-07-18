package com.sqilab.mungai.oauth.controllers;

import com.sqilab.mungai.oauth.models.CustomUser;
import com.sqilab.mungai.oauth.repo.UserRepository;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mungai on 17/07/2017.
 */
@Controller
@RequestMapping("/api/user")
public class UserCotroller {
    @Autowired
    UserRepository repository;

    @Autowired
    PasswordEncoder encoder;

    /**
     * List users
     * @return
     */
    @GetMapping
    public ResponseEntity<?> getUsers(){
        ModelMap model=new ModelMap();
        try{
            model.put("users",repository.findAll());
            model.put("status",true);
            return ResponseEntity.ok(model);
        }catch (Exception e){
            model.put("error","Could not fetch users");
            model.put("status",false);
            return ResponseEntity.badRequest().body(model);
        }
    }

    /**
     * Create a user
     * @param user
     * @return
     */
    @PostMapping("register")
    public ResponseEntity<?> createUserAcccunt(@RequestBody CustomUser user){
        ModelMap model=new ModelMap();
        try{
            user.setPassword(encoder.encode(user.getPassword()));
            repository.save(user);
            model.put("message","User account created");
            model.put("status",true);
            return ResponseEntity.ok(user);
        }catch (Exception e){
            model.put("error","Could not create account: "+e.getMessage());
            model.put("status",false);
            return ResponseEntity.badRequest().body(model);
        }
    }
}
