package com.example.ReactLogin.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.BatchSize;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "user_details")
public class UserModel {

    @Id
    @NotBlank
    private String username;
    @NotBlank
    private String department;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;

    public UserModel(String username, String department, String email, String password) {
        this.username = username;
        this.department = department;
        this.email = email;
        this.password = password;
    }

    public UserModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
