package com.neighborly.backend.services;


import com.neighborly.backend.dtos.RegisterUserRequest;
import com.neighborly.backend.dtos.UpdateUserRequest;
import com.neighborly.backend.dtos.UserDto;
import com.neighborly.backend.entities.User;
import com.neighborly.backend.exceptions.UserAlreadyExistsException;
import com.neighborly.backend.exceptions.UserNotFoundException;
import com.neighborly.backend.mappers.UserMapper;
import com.neighborly.backend.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public User findById(UUID id) {
        var user = userRepository.findById(id).orElse(null);
        if(user == null) {
            throw new UserNotFoundException();
        }
        return user;
    }
    public UserDto createUser(RegisterUserRequest request) {
        if(userRepository.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException();
        }
        var user = userMapper.toEntity(request);
        user.setCreatedAt(Instant.now());
        userRepository.save(user);
        return userMapper.toDto(user);
    }
    public void deleteUserById(UUID id) {
        var user = findById(id);
        userRepository.deleteById(id);

    }
    public User updateUser(UUID id, UpdateUserRequest request) {
        var user = findById(id);
        userMapper.updateUser(request, user);
        userRepository.save(user);
        return user;
    }
}
