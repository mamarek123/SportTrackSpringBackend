package com.sporttrackback.domain.training.Dto;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Builder
public record AddTrainingRequestDto(
        @NotBlank(message = "exerciseName cannot be blank") String exerciseName,
        @NotBlank(message = "erepsAndWeights cannot be blank") String repsAndWeights,
        @NotBlank(message = "note cannot be blank") String note,
        @NotBlank(message = "dateTime cannot be blank") LocalDateTime dateTime) {
}
