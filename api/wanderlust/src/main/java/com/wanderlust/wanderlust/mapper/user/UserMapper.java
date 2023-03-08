package com.wanderlust.wanderlust.mapper.user;

import com.wanderlust.wanderlust.dto.user.UserDTO;
import com.wanderlust.wanderlust.model.role.Role;
import com.wanderlust.wanderlust.model.user.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO toDTO(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        return new UserDTO(
                userModel.getId(),
                userModel.getName(),
                userModel.getUserName(),
                userModel.getEmail(),
                userModel.getCep(),
                userModel.getPassword(),
                Role.getEnumValue(userModel.getRole()),
                userModel.getIsActive());
    }

    public UserModel toEntity(UserDTO userDTO) {

        if (userDTO == null) {
            return null;
        }

        UserModel userModel = new UserModel();
        if (userDTO.id() != null) {
            userModel.setId(userDTO.id());
        }
        userModel.setName(userDTO.name());
        userModel.setCep(userDTO.cep());
        userModel.setEmail(userDTO.email());
        userModel.setPassword(userDTO.password());
        userModel.setIsActive(userDTO.isActive());
        userModel.setUserName(userDTO.userName());
        userModel.setRole(userDTO.role().getDescription());
        return userModel;
    }

}
