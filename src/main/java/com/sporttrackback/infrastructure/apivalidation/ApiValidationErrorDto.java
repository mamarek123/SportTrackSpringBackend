package com.sporttrackback.infrastructure.apivalidation;

import org.springframework.http.HttpStatus;

import java.util.List;

public record ApiValidationErrorDto(
        List<String> messages,
        HttpStatus status
) { }
