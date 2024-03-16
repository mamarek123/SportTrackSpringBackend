package com.sporttrackback.domain.training.Dto;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public record DeleteTrainingRequestDto(
        @NotBlank(message = "exerciseName cannot be blank") String exerciseName,
        @NotBlank(message = "date cannot be blank") LocalDateTime date) {
}
