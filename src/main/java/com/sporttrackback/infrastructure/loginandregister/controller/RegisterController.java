package com.sporttrackback.infrastructure.loginandregister.controller;

import com.sporttrackback.domain.loginAndRegister.DTO.UserRequestDto;
import com.sporttrackback.domain.loginAndRegister.DTO.UserResultDto;
import com.sporttrackback.domain.loginAndRegister.LoginAndRegisterFacade;
import com.sporttrackback.infrastructure.loginandregister.controller.dto.RegisterResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class RegisterController {
    LoginAndRegisterFacade loginAndRegisterFacade;
    private final PasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/register")
    ResponseEntity<RegisterResponseDto> RegisterUser(@RequestBody @Valid UserRequestDto userRequestDto){
        UserRequestDto userEncodedRequestDto = UserRequestDto.builder()
                .password(bCryptPasswordEncoder.encode(userRequestDto.password()))
                .username(userRequestDto.username())
                .build();
        UserResultDto registerResult = loginAndRegisterFacade.register(userEncodedRequestDto);
        return  ResponseEntity.status(HttpStatus.CREATED).body(new RegisterResponseDto(registerResult.username()));
    }

}
