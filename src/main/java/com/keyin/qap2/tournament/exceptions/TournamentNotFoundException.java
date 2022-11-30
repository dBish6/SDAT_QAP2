package com.keyin.qap2.tournament.exceptions;

public class TournamentNotFoundException extends RuntimeException {

    public TournamentNotFoundException() {
        super("ERROR: No tournament(s) were found.");
    }

    public TournamentNotFoundException(Long id) {
        super("ERROR: Could not find tournament with Id " + id + ".");
    }
}
