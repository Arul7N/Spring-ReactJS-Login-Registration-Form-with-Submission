package com.example.ReactLogin.Service;

import com.example.ReactLogin.Config.SecurityConfig;
import com.example.ReactLogin.Dto.LoginDto;
import com.example.ReactLogin.Dto.UserDto;
import com.example.ReactLogin.Model.UserModel;
import com.example.ReactLogin.Repository.UserRepository;
import com.example.ReactLogin.Response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository repo;

    @Autowired
    private PasswordEncoder encoder;
    @Override
    public String addUser(UserDto udto) {

        UserModel user = new UserModel(
                udto.getUsername(),
                udto.getDepartment(),
                udto.getEmail(),

                this.encoder.encode(udto.getPassword())
        );

        repo.save(user);

        return udto.getUsername();
    }

    @Override
    public LoginResponse logUser(LoginDto loginDto) {
        String msg = "";
        UserModel userModelEmail = repo.findByEmail(loginDto.getEmail());
        if(userModelEmail != null){
            String password = loginDto.getPassword();
            String encodedPass = userModelEmail.getPassword();
            Boolean isPwdRight = encoder.matches(password, encodedPass);
            if(isPwdRight){
                Optional<UserModel> userModel = repo.findOneByEmailAndPassword(loginDto.getEmail(),encodedPass);
                if(userModel.isPresent()){
                    return new LoginResponse("Login Successfull...!", true);
                }
                else {
                    return new LoginResponse("Login Failed...!", false);
                }
            }
            else {
                return new LoginResponse("Invalid Password...!", false);
            }
        }
        else {
            return new LoginResponse("Invalid Email...!", false);
        }

    }


}
