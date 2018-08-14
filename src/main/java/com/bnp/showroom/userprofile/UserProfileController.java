package com.bnp.showroom.userprofile;

import com.bnp.showroom.userprofile.UserProfile;
import com.bnp.showroom.userprofile.UserProfileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by CS8593 on 27.07.2018.
 */
@RestController
@RequestMapping("/api/userprofile")
public class UserProfileController {
    private static final Logger logger = LoggerFactory.getLogger(UserProfileController.class);
    private UserProfileRepository userProfileRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @PersistenceContext
    public EntityManager em;

    public UserProfileController(UserProfileRepository userProfileRepository,
                                 BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userProfileRepository = userProfileRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/sign-up")
    public ResponseEntity signUp(@RequestBody UserProfile user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userProfileRepository.save(user);
        //sending mail to customer for email verification
        String verificationURL = CreateVerificationURL(user.getEmail());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    private String CreateVerificationURL(String email) {
        String token = userProfileRepository.findByVerificationToken(email);
        System.out.println(token);
        return token;
    }

//    @RequestMapping(method = RequestMethod.GET, value = "{email}")
//    public ResponseEntity findByEmail(@PathVariable("email") String emailID) {
//        try {
//            System.out.println("test");
//            List result;
//            result = em.createQuery(
//                    "SELECT p  FROM UserProfile p WHERE m.enabled = true AND m.email =:email")
//                    .setParameter("email", emailID)
//                    .getResultList();
//            return new ResponseEntity<>(result, HttpStatus.OK);
//        } catch (Exception ex) {
//            logger.error(ex.getMessage());
//            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }

    @RequestMapping(method = RequestMethod.GET, value = "/sign-up/{token}")
    public ResponseEntity verifyEmailToken(@PathVariable("token") String token) {
        try {
            System.out.println("inside token");
            UserProfile userProfile = userProfileRepository.verifyEmailToken(token);
            if (userProfile != null) {
                userProfile.setEnabled(true);
                userProfileRepository.save(userProfile);
                return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);
            }
            return new ResponseEntity<>("User not found", HttpStatus.NOT_ACCEPTABLE);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}