package com.ucbcba.RegistroMedico.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
public class User {
    private Long id;
    private String username;
    private String password;
    private String role;
    private String passwordConfirm;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getRole() { return role; }

    public void setRole(String role) {
        this.role = role;
    }
}
