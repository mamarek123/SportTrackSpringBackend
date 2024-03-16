package com.sporttrackback.domain.loginAndRegister;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoginAndRegisterConfig {

    @Bean
    LoginAndRegisterFacade loginAndRegisterFacade(LoginAndRegisterRepository loginAndRegisterRepository){
        return new LoginAndRegisterFacade(loginAndRegisterRepository);
    }
}
