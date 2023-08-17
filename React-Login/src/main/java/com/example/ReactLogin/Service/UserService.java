package com.example.ReactLogin.Service;

import com.example.ReactLogin.Dto.LoginDto;
import com.example.ReactLogin.Dto.UserDto;
import com.example.ReactLogin.Model.UserModel;
import com.example.ReactLogin.Response.LoginResponse;

public interface UserService {

    String addUser(UserDto udto);

    LoginResponse logUser(LoginDto loginDto);
}
