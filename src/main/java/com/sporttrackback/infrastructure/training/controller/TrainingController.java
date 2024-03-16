package com.sporttrackback.infrastructure.training.controller;

import com.sporttrackback.domain.training.Dto.AddTrainingRequestDto;
import com.sporttrackback.domain.training.Dto.DeleteTrainingRequestDto;
import com.sporttrackback.domain.training.Dto.TrainingResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import com.sporttrackback.domain.training.TrainingFacade;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
public class TrainingController {

    private final TrainingFacade trainingsFacade;

    @GetMapping("/trainings/ForDay")
    public ResponseEntity<List<TrainingResponseDto>> getTrainingsForUserOnDay(
            @RequestParam int year,
            @RequestParam int month,
            @RequestParam int day) {
        LocalDate requestDay = LocalDate.of(year,month,day);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();


        List<TrainingResponseDto> trainings = trainingsFacade.getTrainingsForUserOnDay(requestDay, currentUsername);
        return ResponseEntity.ok(trainings);
    }

    @GetMapping("/trainings/ForExercise")
    public ResponseEntity<List<TrainingResponseDto>> getTrainingsForUserOnExercise(
            @RequestParam String exercise) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();

        List<TrainingResponseDto> trainings = trainingsFacade.getTrainingsForUserOnExercise(exercise, currentUsername);
        return ResponseEntity.ok(trainings);
    }

    @PostMapping("/trainings/add")
    public ResponseEntity<TrainingResponseDto> addOneTraining(@RequestBody @Valid AddTrainingRequestDto addTrainingRequestDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();
        return ResponseEntity.ok(trainingsFacade.addTraining(addTrainingRequestDto, currentUsername));
    }

    @DeleteMapping("/trainings/delete")
    public void deleteOneTraining(@RequestBody @Valid DeleteTrainingRequestDto deleteTrainingRequestDto){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();
        trainingsFacade.deleteTraining(deleteTrainingRequestDto,currentUsername);
    }

    @GetMapping("/trainings/user/exercises")
    public List<String> getUsersExercises(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();
        return trainingsFacade.getDistinctExercisesForUser(currentUsername);
    }



}