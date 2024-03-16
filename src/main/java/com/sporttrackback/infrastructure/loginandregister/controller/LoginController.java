package com.sporttrackback.infrastructure.loginandregister.controller;

import com.sporttrackback.infrastructure.jwt.JwTAuthenthicator;
import com.sporttrackback.infrastructure.loginandregister.controller.dto.LoginRequestDto;
import com.sporttrackback.infrastructure.loginandregister.controller.dto.LoginResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class LoginController {

    JwTAuthenthicator jwTAuthenthicator;
    @PostMapping("/token")
    ResponseEntity<LoginResponseDto> authenthicateAndGenerateToken(@RequestBody @Valid LoginRequestDto tokenRequestDto){
        LoginResponseDto loginResponseDto = jwTAuthenthicator.authenticateAndGenerateToken(tokenRequestDto);
        return ResponseEntity.ok(loginResponseDto);
    }

}
