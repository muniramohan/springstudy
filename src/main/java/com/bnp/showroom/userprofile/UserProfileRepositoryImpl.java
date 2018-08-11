package com.bnp.showroom.userprofile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProfileRepositoryImpl {

    @Autowired
    private UserProfileRepository userProfileRepository;

    public boolean verifyEmail(String emailID) {
        try {
            UserProfile applicationUser = userProfileRepository.findByEmail(emailID);

            if (applicationUser == null) {
                System.out.println("User is not active");
            }
                return true;
        }catch (Exception ex){
            return false;
        }
    }

}
