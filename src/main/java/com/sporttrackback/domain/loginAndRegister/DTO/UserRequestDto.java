package com.sporttrackback.domain.loginAndRegister.DTO;

import lombok.Builder;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
public record UserRequestDto(
        @NotBlank(message = "Username cannot be blank")
        String username,

        @NotBlank(message = "Password cannot be blank")
        @Size(min = 6, message = "Password must be at least 6 characters long")
        String password
) {}