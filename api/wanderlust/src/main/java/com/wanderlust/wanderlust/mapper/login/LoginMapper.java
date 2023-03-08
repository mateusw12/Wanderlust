package com.wanderlust.wanderlust.mapper.login;

import com.wanderlust.wanderlust.dto.login.LoginDTO;
import com.wanderlust.wanderlust.model.login.LoginModel;
import org.springframework.stereotype.Component;

@Component
public class LoginMapper {

    public LoginDTO toDTO(LoginModel loginModel) {
        if (loginModel == null) {
            return null;
        }
        return new LoginDTO(
                loginModel.getUserName(),
                loginModel.getPassword());
    }

    public LoginModel toEntity(LoginDTO loginDTO) {

        if (loginDTO == null) {
            return null;
        }

        LoginModel loginModel = new LoginModel();
        loginModel.setPassword(loginDTO.password());
        loginModel.setUserName(loginDTO.userName());
        return loginModel;
    }

}
