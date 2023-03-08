package com.wanderlust.wanderlust.controller.authentication;

import com.wanderlust.wanderlust.dto.login.LoginDTO;
import com.wanderlust.wanderlust.model.login.UserTokenModel;
import com.wanderlust.wanderlust.repository.user.UserRepository;
import com.wanderlust.wanderlust.security.utils.JWTUtil;
import com.wanderlust.wanderlust.service.impl.detailUserService.DetailUserServiceImpl;
import com.wanderlust.wanderlust.validator.user.UserCustomValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;

@Validated
@RestController
@RequestMapping("/api/login")
public class AuthenticationController {

    @Autowired
    private DetailUserServiceImpl serviceMyUserDetail;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JWTUtil serviceJWT;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserCustomValidation userCustomValidation;

    @PostMapping()
    public ResponseEntity<UserTokenModel> login(@RequestBody @Valid LoginDTO loginDTO) {

        if (!this.userCustomValidation.validateActiveUser(loginDTO.userName())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        UserDetails userDetails = serviceMyUserDetail.loadUserByUsername(loginDTO.userName());

        if (!passwordEncoder.matches(loginDTO.password(), userDetails.getPassword())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        String token = serviceJWT.generateToken(userDetails);
        return ResponseEntity.ok(buildUserToken(loginDTO.userName(), token));
    }

    private UserTokenModel buildUserToken(String userName, String token) {
        Date expirationDate = serviceJWT.getExpirationTokenDate();

        UserTokenModel userTokenDTO = new UserTokenModel();
        userTokenDTO.userName = userName;
        userTokenDTO.token = token;
        userTokenDTO.expirationDate = expirationDate;
        return userTokenDTO;
    }

}
