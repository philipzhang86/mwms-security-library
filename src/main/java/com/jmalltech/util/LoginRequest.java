package com.jmalltech.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginRequest {
    private String username;
    private String password;

    public LoginRequest() {
        this.username = "admin";
        this.password = "admin";
    }
}
