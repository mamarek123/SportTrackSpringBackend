package com.sporttrackback.domain.training;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public interface TrainingRepository extends MongoRepository<Training, String> {
    List<Training> findByUsernameAndExerciseName(String userId, String exerciseName);

    List<Training> findByUsernameAndDateTimeBetween(String username, LocalDateTime start, LocalDateTime end);

    Optional<Training> findByUsernameAndExerciseNameAndDateTimeBetween(String username, String exerciseName, LocalDateTime start, LocalDateTime end);

    List<Training> findByUsername(String username);


}
