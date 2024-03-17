package com.sporttrackback.domain.loginAndRegister;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
class LoginAndRegisterConfig {

    LoginAndRegisterRepository loginAndRegisterRepository;
    @Bean
    LoginAndRegisterFacade loginAndRegisterFacade(LoginAndRegisterRepository loginAndRegisterRepository){
        return new LoginAndRegisterFacade(loginAndRegisterRepository);
    }
}
