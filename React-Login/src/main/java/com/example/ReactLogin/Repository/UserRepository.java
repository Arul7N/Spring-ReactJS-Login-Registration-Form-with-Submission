package com.example.ReactLogin.Repository;

import com.example.ReactLogin.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<UserModel, String> {



    Optional<UserModel> findOneByEmailAndPassword(String email, String password);

    UserModel findByEmail(String email);
}
