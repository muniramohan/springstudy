package com.bnp.showroom.service;

import com.bnp.showroom.userprofile.UserProfile;
import com.bnp.showroom.userprofile.UserProfileRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

/**
 * Created by CS8593 on 27.07.2018.
 */
@Service
public class UserProfileServiceImpl implements UserDetailsService {
    private UserProfileRepository userProfileRepository;

    public UserProfileServiceImpl(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserProfile applicationUser = userProfileRepository.findByEmail(username);
        if (applicationUser == null) {
            UserProfile applicationUserNoCheck = userProfileRepository.findByOnlyEmail(username);
            if (applicationUserNoCheck != null){
                return new User(applicationUserNoCheck.getEmail(), applicationUserNoCheck.getPassword(), false , false, false , false, emptyList());
            }
            throw new UsernameNotFoundException(username);
        }
        System.out.println("email" + applicationUser.getEmail() + "psswd:" + applicationUser.getPassword());
        return new User(applicationUser.getEmail(), applicationUser.getPassword(), emptyList());
    }
}
