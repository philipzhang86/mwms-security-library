package com.jmalltech.security.controller;

import com.jmalltech.security.entity.IUser;
import com.jmalltech.security.mapper.SecurityClientMapper;
import com.jmalltech.security.mapper.SecurityStaffMapper;
import com.jmalltech.security.util.JwtUtil;
import com.jmalltech.security.util.LoginRequest;
import com.jmalltech.security.util.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    @Autowired
    private SecurityClientMapper clientMapper;

    @Autowired
    private SecurityStaffMapper staffMapper;

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        System.out.println("Attempting to login with username: " + loginRequest.getUsername());

        IUser user = staffMapper.getByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
        String role = null;

        if(user != null) {
            role = "STAFF";
        } else {
            user = clientMapper.getByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
            if(user != null) {
                role = "CLIENT";
            }
        }
        if(user != null){
            String token = JwtUtil.generateToken(user, role);
            System.out.println("Generated token: " + token);
            return ResponseEntity.ok(new TokenResponse(token));
        }else {
            System.out.println("Login failed for username: " + loginRequest.getUsername());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
}
