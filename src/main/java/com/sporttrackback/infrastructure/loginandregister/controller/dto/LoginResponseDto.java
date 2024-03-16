package com.sporttrackback.infrastructure.loginandregister.controller.dto;

import lombok.Builder;

@Builder
public record LoginResponseDto(String username, String token) {

}
