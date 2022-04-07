package com.example.demo.dto.respond;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtRespond {
    private String token;
    private String type="Bearer";
    private String username;
    private Collection<? extends GrantedAuthority> roles;

    public JwtRespond(String token, String type, String username, Collection<? extends GrantedAuthority> roles) {
        this.token = token;
        this.type = type;
        this.username = username;
        this.roles = roles;
    }

    public JwtRespond() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Collection<? extends GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(Collection<? extends GrantedAuthority> roles) {
        this.roles = roles;
    }

    public JwtRespond(String token, String username, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.username = username;
        this.roles = authorities;
    }
}
