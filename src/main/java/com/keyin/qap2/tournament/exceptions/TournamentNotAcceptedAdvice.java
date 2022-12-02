package com.keyin.qap2.tournament.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

// Configuration of exception.
@ControllerAdvice
class TournamentNotAcceptedAdvice {

    @ResponseBody
    @ExceptionHandler(TournamentNotAcceptedException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    String tournamentNotAcceptedHandler(TournamentNotAcceptedException e) {
        return e.getMessage();
    }
}
