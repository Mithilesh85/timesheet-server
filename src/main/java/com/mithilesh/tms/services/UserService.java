package com.mithilesh.tms.services;

import com.mithilesh.tms.dto.UserDto;

import java.util.List;

public interface UserService {

    //to get single user
//    UserDto getUser(String userId);

    //to get all the user
//    List<UserDto> getAllUsers();

    //to add user
    UserDto registerNewUser(UserDto userDto);

    //to update user
//    UserDto updateUser(String userId,UserDto userDto);

    //to delete user
//    void deleteUser(String userId);
}
