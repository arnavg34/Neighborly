package com.neighborly.backend.dtos.User;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private String name;
    private String email;
}
