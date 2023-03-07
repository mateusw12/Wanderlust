package com.wanderlust.wanderlust.service.user;

import com.wanderlust.wanderlust.dto.user.UserDTO;
import com.wanderlust.wanderlust.mapper.user.UserMapper;
import com.wanderlust.wanderlust.model.user.UserModel;
import com.wanderlust.wanderlust.repository.user.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder encoder;

    public UserService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.encoder = encoder;
    }

    @Transactional
    public List<UserDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public UserDTO findById(Long id) {
        return userRepository.findById(id).map(userMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("User not found" + id));
    }

    @Transactional
    public UserDTO create(UserDTO userDTO) {
      UserModel userModel = userMapper.toEntity(userDTO);
      userModel.setPassword(encoder.encode(userDTO.password()));
        return userMapper.toDTO(userRepository.save(userModel));
    }

    @Transactional
    public UserDTO update(Long id, UserDTO userDTO) {
        return userRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setName(userDTO.name());
                    recordFound.setCep(userDTO.cep());
                    recordFound.setEmail(userDTO.email());
                    recordFound.setIsActive(userDTO.isActive());
                    recordFound.setPassword(encoder.encode(userDTO.password()));
                    recordFound.setRole(userDTO.role());
                    recordFound.setUserName(userDTO.userName());
                    return userMapper.toDTO(userRepository.save(recordFound));
                }).orElseThrow(() -> new EntityNotFoundException("User not found" + id));
    }

    @Transactional
    public void delete(Long id) {
        userRepository.delete(userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found" + id)));
    }

}
