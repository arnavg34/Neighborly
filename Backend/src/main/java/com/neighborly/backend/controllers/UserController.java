package com.neighborly.backend.controllers;


import com.neighborly.backend.dtos.User.RegisterUserRequest;
import com.neighborly.backend.dtos.User.UpdateUserRequest;
import com.neighborly.backend.dtos.User.UserDto;
import com.neighborly.backend.exceptions.UserAlreadyExistsException;
import com.neighborly.backend.exceptions.UserNotFoundException;
import com.neighborly.backend.mappers.UserMapper;
import com.neighborly.backend.repositories.UserRepository;
import com.neighborly.backend.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    UserRepository userRepository;
    UserMapper userMapper;
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable UUID id) {
        return ResponseEntity.ok(userMapper.toDto(userService.findById(id)));
    }
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody @Valid RegisterUserRequest request, UriComponentsBuilder uriBuilder) {
        var userDto = userService.createUser(request);
        var uri = uriBuilder.path("/user/{id}").buildAndExpand(userDto.getId()).toUri();
        return ResponseEntity.created(uri).body(userDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(
            @PathVariable(name="id") UUID id
    ) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(
            @PathVariable(name="id") UUID id,
            @RequestBody UpdateUserRequest request
    ) {
        return ResponseEntity.ok(userMapper.toDto(userService.updateUser(id, request)));
    }

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<Map<String,String>> handleUserNotFound(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of("error", "User not found."));
    }
    @ExceptionHandler({UserAlreadyExistsException.class})
    public ResponseEntity<Map<String,String>> handleUserAlreadyExists(){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                Map.of("error", "User Already Exists."));
    }
}
