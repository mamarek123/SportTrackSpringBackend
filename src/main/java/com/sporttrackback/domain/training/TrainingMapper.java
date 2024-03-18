package com.sporttrackback.domain.training;


import com.sporttrackback.domain.training.Dto.AddTrainingRequestDto;
import com.sporttrackback.domain.training.Dto.TrainingResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class TrainingMapper {
    public static List<TrainingResponseDto> trainingListToTrainingResponseDtoList(List<Training> trainings) {
        List<TrainingResponseDto> trainingResponseDtoList = trainings.stream().map(TrainingMapper::trainingToTrainingResponseDto).collect(Collectors.toList());
        return trainingResponseDtoList;
    }

    public static TrainingResponseDto trainingToTrainingResponseDto(Training training){
        return TrainingResponseDto.builder()
                .id(training.id())
                .note(training.note())
                .dateTime(training.dateTime())
                .exerciseName(training.exerciseName())
                .repsAndWeights(training.repsAndWeights())
                .build();
    }

    public static Training addTrainingRequestDtoAndUserToTraining(AddTrainingRequestDto addTrainingRequestDto, String username){
        return Training.builder()
                .note(addTrainingRequestDto.note())
                .exerciseName(addTrainingRequestDto.exerciseName())
                .dateTime(addTrainingRequestDto.dateTime())
                .repsAndWeights(addTrainingRequestDto.repsAndWeights())
                .username(username)
                .build();
    }
}
