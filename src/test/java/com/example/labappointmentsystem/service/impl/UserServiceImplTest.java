package com.example.labappointmentsystem.service.impl;

import com.example.labappointmentsystem.dto.UserDto;
import com.example.labappointmentsystem.entity.Role;
import com.example.labappointmentsystem.entity.User;
import com.example.labappointmentsystem.repository.RoleRepository;
import com.example.labappointmentsystem.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void saveUser() {
        UserDto userDto = new UserDto(
                1L, "Imalka", "Wijerathna", "imalka@test.com", "123456789"
        );
        User user = new User();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setEmail(userDto.getEmail());

        //encrypt the password once we integrate spring security
        //user.setPassword(userDto.getPassword());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Role role = roleRepository.findByName("ROLE_ADMIN");
        if(role == null){
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);


        User savedUser = userRepository.findByEmail("imalka@test.com");

        assertEquals(user.getId(), savedUser.getId());

    }


    private Role checkRoleExist() {
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }

    @Test
    void findByEmail() {
    }

    @Test
    void findAllUsers() {
    }
}