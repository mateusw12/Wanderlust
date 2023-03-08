package com.wanderlust.wanderlust.configuration;

import com.wanderlust.wanderlust.model.user.UserModel;
import com.wanderlust.wanderlust.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;

@Configuration
public class DatabaseInitializer {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        UserModel userModel = userRepository.findByUserName("mateus");

        if (userModel == null) {
            UserModel user = new UserModel();
            user.setUserName("mateus");
            user.setPassword(passwordEncoder.encode("123456"));
            user.setName("Mateus");
            user.setEmail("mateus.walz@gmail.com");
            user.setCep("6666666");
            user.setRole("Admnistrador");
            user.setIsActive(true);
            userRepository.save(user);
        }
    }

}
