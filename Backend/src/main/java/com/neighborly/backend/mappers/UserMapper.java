package com.neighborly.backend.mappers;


import com.neighborly.backend.dtos.RegisterUserRequest;
import com.neighborly.backend.dtos.UpdateUserRequest;
import com.neighborly.backend.dtos.UserDto;
import com.neighborly.backend.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(RegisterUserRequest request);
    void updateUser(UpdateUserRequest request, @MappingTarget User user);
}
