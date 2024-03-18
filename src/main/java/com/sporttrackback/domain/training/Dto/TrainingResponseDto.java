package com.sporttrackback.domain.training.Dto;

import lombok.Builder;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Builder
public record TrainingResponseDto(String id,
                                  String exerciseName,
                                  String repsAndWeights,
                                  String note,
                                  LocalDateTime dateTime) {
}
