package com.bnp.showroom.security;

import com.bnp.showroom.service.UserProfileServiceImpl;
import com.bnp.showroom.userprofile.UserProfileRepository;
import com.bnp.showroom.userprofile.UserProfileRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import com.bnp.showroom.userprofile.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static com.bnp.showroom.security.SecurityConstants.EXPIRATION_TIME;
import static com.bnp.showroom.security.SecurityConstants.HEADER_STRING;
import static com.bnp.showroom.security.SecurityConstants.SECRET;
import static com.bnp.showroom.security.SecurityConstants.TOKEN_PREFIX;

/**
 * Created by CS8593 on 27.07.2018.
 */
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;

    //private UserProfileRepository userProfileRepository;

   // private UserProfileRepositoryImpl userProfileRepositoryImpl = new UserProfileRepositoryImpl();

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {
            UserProfile creds = new ObjectMapper()
                    .readValue(req.getInputStream(), UserProfile.class);
//            System.out.println("creds :" + creds.getEmail() + "pswd" + creds.getPassword());
//            Boolean applicationUser = userProfileRepositoryImpl.verifyEmail(creds.getEmail());
//            if (applicationUser == false) {
//                throw new DisabledException("User is not active");
//            }
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getEmail(),
                            creds.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
        System.out.println("success authentication");
        String token = Jwts.builder()
                .setSubject(((User) auth.getPrincipal()).getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET.getBytes())
                .compact();
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
    }
}