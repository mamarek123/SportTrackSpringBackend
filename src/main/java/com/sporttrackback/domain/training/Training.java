package com.sporttrackback.domain.training;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Builder
@Document
public record Training(
        @Id String id,
        String username,
        String exerciseName,
        String repsAndWeights,
        String note,
        LocalDateTime dateTime
        ) {
}
