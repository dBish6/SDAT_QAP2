package com.keyin.qap2.tournament.exceptions;

public class TournamentNotAcceptedException extends RuntimeException {

    public TournamentNotAcceptedException() {
        super("ERROR: No tournament should have empty fields.");
    }
}
