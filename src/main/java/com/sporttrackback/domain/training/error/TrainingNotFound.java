package com.sporttrackback.domain.training.error;

public class TrainingNotFound extends RuntimeException{
    public TrainingNotFound(String message) {
        super(message);
    }
}
