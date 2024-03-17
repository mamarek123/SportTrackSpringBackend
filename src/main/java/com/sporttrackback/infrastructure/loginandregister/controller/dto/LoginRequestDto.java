package com.sporttrackback.infrastructure.loginandregister.controller.dto;

import javax.validation.constraints.NotBlank;

public record LoginRequestDto(@NotBlank String username,@NotBlank String password) {
}
