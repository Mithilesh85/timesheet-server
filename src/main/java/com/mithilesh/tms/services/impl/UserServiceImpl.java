package com.mithilesh.tms.services.impl;

import com.mithilesh.tms.dto.UserDto;
import com.mithilesh.tms.entity.User;
import com.mithilesh.tms.repository.UserRepository;
import com.mithilesh.tms.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public UserDto registerNewUser(UserDto userDto) {
        String randomUserId = UUID.randomUUID().toString();
        User user = this.modelMapper.map(userDto, User.class);
        user.setUserId(randomUserId);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = this.userRepository.save(user);
        return this.modelMapper.map(savedUser,UserDto.class);
    }

}
