package com.sporttrackback.domain.loginAndRegister;


import com.sporttrackback.infrastructure.loginandregister.controller.dto.RegisterRequestDto;
import com.sporttrackback.domain.loginAndRegister.DTO.UserResultDto;

class UserMapper {
    static UserResultDto userToUserResultDto(User user) {
        UserResultDto userResultDto = UserResultDto.builder().
                username(user.username())
                .password(user.password())
                .id(user.id()).
                build();
        return userResultDto;
    }
    static User userRequestDtoToUser(RegisterRequestDto userRequestDTO) {
        User user =  User.builder()
                .username(userRequestDTO.username())
                .password(userRequestDTO.password())
                .build();
        return user;
    }
}
