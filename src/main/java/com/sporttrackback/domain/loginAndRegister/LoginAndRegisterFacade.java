package com.sporttrackback.domain.loginAndRegister;

import com.sporttrackback.infrastructure.loginandregister.controller.dto.RegisterRequestDto;
import com.sporttrackback.domain.loginAndRegister.DTO.UserResultDto;
import com.sporttrackback.domain.loginAndRegister.error.UserAlreadyExistsException;
import org.springframework.security.authentication.BadCredentialsException;


public class LoginAndRegisterFacade {
    LoginAndRegisterFacade(LoginAndRegisterRepository registerRepostiory) {
        this.registerRepostiory = registerRepostiory;
    }

    private final LoginAndRegisterRepository registerRepostiory;

    public UserResultDto findByUsername(String username){
        User user = registerRepostiory.getByUsername(username).orElseThrow(() -> new BadCredentialsException("User not found"));
        return UserMapper.userToUserResultDto(user);
    }

    public UserResultDto register(RegisterRequestDto userRequestDto) {
        if (registerRepostiory.existsByUsername(userRequestDto.username())) {
            throw new UserAlreadyExistsException("User with username " + userRequestDto.username() + " already exists");
        }

        User user = UserMapper.userRequestDtoToUser(userRequestDto);
        User savedUser = registerRepostiory.save(user);
        return UserMapper.userToUserResultDto(savedUser);
    }

}
