package com.sporttrackback.domain.training.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record DeleteTrainingRequestDto(
        @NotBlank(message = "id cannot be blank") @NotNull(message = "id cannot be null") String id){
}
