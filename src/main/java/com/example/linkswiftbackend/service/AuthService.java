package com.example.linkswiftbackend.service;

import com.example.linkswiftbackend.model.dto.UserDto;
import com.example.linkswiftbackend.model.entity.UserEntity;
import com.example.linkswiftbackend.model.enums.UserType;
import com.example.linkswiftbackend.repository.AuthRepository;
import com.example.linkswiftbackend.utils.config.exceptions.EmailAlreadyExistException;
import com.example.linkswiftbackend.utils.config.exceptions.InvalidCredentialsException;
import com.example.linkswiftbackend.utils.config.security.JwtUtil;
import com.example.linkswiftbackend.utils.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private AuthRepository authRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JwtUtil jwtUtil;

    public String register(UserDto user) {
        if(authRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new EmailAlreadyExistException("Email already in use.");
        }
        user.setType(UserType.USER);
        user.setSearchJob(false);
        user.setGrade(null);
        user.setCourse(null);
        user.setCompanyId(null);
        user.setSchoolId(null);

        UserEntity userEntity = userMapper.toEntity(user);
        String encodedPassword = passwordEncoder.encode(userEntity.getPassword());
        userEntity.setPassword(encodedPassword);

        UserEntity savedUser = authRepository.save(userEntity);
        return jwtUtil.generateToken(savedUser.getId());
    }

    public String login(String email, String password) {
        UserEntity user = authRepository.findByEmail(email).orElseThrow(() -> new InvalidCredentialsException("Invalid email or password"));
        if(!passwordEncoder.matches(password, user.getPassword())) {
            throw new InvalidCredentialsException("Invalid email or password");
        }
        return jwtUtil.generateToken(user.getId());
    }
}
