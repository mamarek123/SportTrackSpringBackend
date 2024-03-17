package com.sporttrackback.domain.training.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record DeleteTrainingRequestDto(
        @NotBlank(message = "exerciseName cannot be blank") String exerciseName,
        @NotNull LocalDateTime date) {
}
