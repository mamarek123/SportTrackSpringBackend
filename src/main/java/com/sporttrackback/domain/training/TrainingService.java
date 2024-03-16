package com.sporttrackback.domain.training;

import com.sporttrackback.domain.training.Dto.AddTrainingRequestDto;
import com.sporttrackback.domain.training.Dto.DeleteTrainingRequestDto;
import com.sporttrackback.domain.training.error.TrainingNotFound;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TrainingService {
    private final TrainingRepository trainingRepository;

    String getIdForTrainingWithGivenUsernameExerciseAndDate(String username, DeleteTrainingRequestDto deleteTrainingRequestDto) {
        String exerciseName = deleteTrainingRequestDto.exerciseName();
        LocalDate date = deleteTrainingRequestDto.date().toLocalDate();

        LocalDateTime startOfDay = LocalDateTime.of(date, LocalTime.MIN);
        LocalDateTime endOfDay = LocalDateTime.of(date, LocalTime.MAX);

        Optional<Training> training = trainingRepository.findByUsernameAndExerciseNameAndDateTimeBetween(username,exerciseName,startOfDay,endOfDay);
        return training.orElseThrow(() -> new TrainingNotFound("No trainings found for user " + username + " on " + date)).id();
    }

    List<String> getDistinctExercisesForUser(String username) {
        List<Training> trainings = trainingRepository.findByUsername(username);
        return trainings.stream()
                .map(Training::exerciseName)
                .distinct()
                .collect(Collectors.toList());
    }


    List<Training> getTrainingsForUserOnDay(LocalDate date, String username) {
        LocalDateTime startOfDay = LocalDateTime.of(date, LocalTime.MIN);
        LocalDateTime endOfDay = LocalDateTime.of(date, LocalTime.MAX);

        List<Training> trainings = trainingRepository.findByUsernameAndDateTimeBetween(username, startOfDay,endOfDay);
        return trainings;

    }

    Training addTrainingForUser(AddTrainingRequestDto addTrainingRequestDto, String username) {
        Training insert = trainingRepository.insert(TrainingMapper.addTrainingRequestDtoAndUserToTraining(addTrainingRequestDto, username));
        return insert;
    }
}