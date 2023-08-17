package com.example.ReactLogin.Controller;

import com.example.ReactLogin.Dto.LoginDto;
import com.example.ReactLogin.Dto.UserDto;
import com.example.ReactLogin.Response.LoginResponse;
import com.example.ReactLogin.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/add-user")
    public String createUser(@RequestBody UserDto userDto){
        service.addUser(userDto);
        return "User Registered...!";
    }


    @PostMapping("/login-user")
    ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto){
        LoginResponse loginResponse = service.logUser(loginDto);
        return ResponseEntity.ok(loginResponse);
    }

}
