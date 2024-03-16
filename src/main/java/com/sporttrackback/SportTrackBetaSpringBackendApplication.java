package com.sporttrackback;

import com.sporttrackback.infrastructure.jwt.JwtConfigurationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
    @EnableConfigurationProperties(value = {JwtConfigurationProperties.class})
@CrossOrigin(origins = {"http://ec2-3-70-127-40.eu-central-1.compute.amazonaws.com:3000","localhost:3000"})
    public class SportTrackBetaSpringBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportTrackBetaSpringBackendApplication.class, args);
    }
}
