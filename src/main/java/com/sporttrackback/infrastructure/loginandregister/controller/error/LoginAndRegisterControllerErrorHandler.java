package com.sporttrackback.infrastructure.loginandregister.controller.error;

import com.sporttrackback.domain.loginAndRegister.error.UserAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class LoginAndRegisterControllerErrorHandler {


    private static final String BAD_CREDENTIALS = "Bad Credentials";

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(BadCredentialsException.class)
    @ResponseBody
    public LoginRegisterErrorResponse handleBadCredentials() {
        return new LoginRegisterErrorResponse(BAD_CREDENTIALS, HttpStatus.UNAUTHORIZED);
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseBody
    public LoginRegisterErrorResponse handleUserAlreadyExists(UserAlreadyExistsException e) {
        return new LoginRegisterErrorResponse(e.getMessage(), HttpStatus.CONFLICT);
    }

}
