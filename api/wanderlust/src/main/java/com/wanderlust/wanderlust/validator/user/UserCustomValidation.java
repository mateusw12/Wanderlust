package com.wanderlust.wanderlust.validator.user;

import com.wanderlust.wanderlust.model.user.UserModel;
import com.wanderlust.wanderlust.repository.user.UserRepository;
import com.wanderlust.wanderlust.security.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserCustomValidation {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JWTUtil jwtUtil;

    public boolean validateActiveUser(String userName) {
        UserModel userModel = userRepository.findByUserName(userName);
        return userModel.getIsActive();
    }

    public boolean validadeLoggedUser(String userName) {
        UserModel userModel = userRepository.findByUserName(userName);
        String loggedUser = jwtUtil.findMe();
        return userModel.getUserName() == loggedUser;
    }

}
