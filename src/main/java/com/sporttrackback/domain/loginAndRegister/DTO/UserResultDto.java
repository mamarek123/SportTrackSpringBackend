package com.sporttrackback.domain.loginAndRegister.DTO;

import lombok.Builder;

@Builder
public record UserResultDto(String id, String username, String password) {

}
