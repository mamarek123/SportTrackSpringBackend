package com.sporttrackback.domain.training;


import com.sporttrackback.domain.training.Dto.AddTrainingRequestDto;
import com.sporttrackback.domain.training.Dto.DeleteTrainingRequestDto;
import com.sporttrackback.domain.training.Dto.TrainingResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@AllArgsConstructor
public class TrainingFacade {
    private final TrainingService trainingService;
    private final TrainingRepository trainingRepository;

    public List<TrainingResponseDto> getTrainingsForUserOnDay(LocalDate day, String username) {
        List<Training> trainings = trainingService.getTrainingsForUserOnDay(day, username);
        List<TrainingResponseDto> trainingResponseDtos = TrainingMapper.trainingListToTrainingResponseDtoList(trainings);
        return trainingResponseDtos;
    }
    public List<TrainingResponseDto> getTrainingsForUserOnExercise(String exerciseName, String username){
        List<Training> trainings = trainingRepository.findByUsernameAndExerciseName(username, exerciseName);
        List<TrainingResponseDto> trainingResponseDtos = TrainingMapper.trainingListToTrainingResponseDtoList(trainings);
        return  trainingResponseDtos;
    }

    public List<String> getDistinctExercisesForUser(String username){
        return trainingService.getDistinctExercisesForUser(username);
    }

    public TrainingResponseDto addTraining(AddTrainingRequestDto addTrainingRequestDto, String username){
        Training addedTraining = trainingService.addTrainingForUser(addTrainingRequestDto,username);
        return TrainingMapper.trainingToTrainingResponseDto(addedTraining);
    }

    public void deleteTraining(DeleteTrainingRequestDto deleteTrainingRequestDto, String username){
        trainingService.verifyAndDeleteTraining(deleteTrainingRequestDto, username);
    }
}
