package com.sporttrackback.infrastructure.loginandregister.controller.dto;

import lombok.Builder;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
public record RegisterRequestDto(
        @NotBlank(message = "Username cannot be blank")
        String username,

        @NotBlank(message = "Password cannot be blank")
        @Size(min = 6, message = "Password must be at least 6 characters long")
        String password
) {}