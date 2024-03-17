package com.sporttrackback;

import com.sporttrackback.infrastructure.jwt.JwtConfigurationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
    @EnableConfigurationProperties(value = {JwtConfigurationProperties.class})
    public class SportTrackBetaSpringBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportTrackBetaSpringBackendApplication.class, args);
    }
}
