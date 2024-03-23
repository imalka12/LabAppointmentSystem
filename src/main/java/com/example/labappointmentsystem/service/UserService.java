package com.example.labappointmentsystem.service;

import com.example.labappointmentsystem.dto.UserDto;
import com.example.labappointmentsystem.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}
