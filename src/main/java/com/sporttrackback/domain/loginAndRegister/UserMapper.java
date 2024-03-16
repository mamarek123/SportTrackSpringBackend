package com.sporttrackback.domain.loginAndRegister;


import com.sporttrackback.domain.loginAndRegister.DTO.UserRequestDto;
import com.sporttrackback.domain.loginAndRegister.DTO.UserResultDto;

class UserMapper {
    static UserResultDto userToUserResultDto(User user) {
        UserResultDto userResultDto = UserResultDto.builder().
                username(user.username()).
                build();
        return userResultDto;
    }
    static User userRequestDtoToUser(UserRequestDto userRequestDTO) {
        User user =  User.builder()
                .username(userRequestDTO.username())
                .password(userRequestDTO.password())
                .build();
        return user;
    }
}
