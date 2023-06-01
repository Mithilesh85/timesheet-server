package com.mithilesh.tms.services;

import com.mithilesh.tms.config.MyUserDetails;
import com.mithilesh.tms.dto.UserDto;
import com.mithilesh.tms.entity.User;
import com.mithilesh.tms.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

         User user = this.userRepository.findByEmail(username);
        Optional<UserDto> userOptional =  Optional.of(this.modelMapper.map(user, UserDto.class));
        return userOptional.map(MyUserDetails::new)
                .orElseThrow(()-> new UsernameNotFoundException("User Not Found this email: "+username));

    }
}
