package com.sqilab.mungai.oauth.services;

import com.sqilab.mungai.oauth.models.CustomUser;
import com.sqilab.mungai.oauth.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by mungai on 17/07/2017.
 */
@Service
public class UserDetailService implements UserDetailsService{
    @Autowired
    UserRepository repository;

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
            Optional<CustomUser> detail=repository.findByUsername(username);
            if(detail.isPresent()){
                CustomUser u=detail.get();
                Collection<GrantedAuthority> authorities=new ArrayList<>();
                return new User(u.getUsername(),u.getPassword(),authorities);
            }
            return null;
        }catch(Exception e){
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"User login ",e);
            return null;
        }
    }

    /**
     * Create new account for the given user
     * @param user User account to create
     */
    public void saveUser(CustomUser user){
        user.setPassword(getPasswordEncoder().encode(user.getPassword()));
        repository.save(user);
    }
}
