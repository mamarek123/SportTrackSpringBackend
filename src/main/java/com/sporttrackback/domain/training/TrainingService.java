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

    void verifyAndDeleteTraining(DeleteTrainingRequestDto deleteTrainingRequestDto, String username) {
        String id = deleteTrainingRequestDto.id();
        Training training = trainingRepository.findById(id).orElseThrow(() -> new TrainingNotFound("Training with id " + id + " notFound"));
        if (training.username().equals(username))
            trainingRepository.deleteById(id);
    }
}
