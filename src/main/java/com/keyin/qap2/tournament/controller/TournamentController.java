package com.keyin.qap2.tournament.controller;

import com.keyin.qap2.tournament.exceptions.TournamentNotAcceptedException;
import com.keyin.qap2.tournament.respository.TournamentRepository;
import com.keyin.qap2.tournament.exceptions.TournamentNotFoundException;
import com.keyin.qap2.tournament.model.Tournament;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/api/")
public class TournamentController {
    @Autowired
    TournamentRepository tournamentRepository;

    // Get all Records
    @GetMapping("/tournaments")
    public List<Tournament> getAllCities() {
        List<Tournament> tournaments = (List<Tournament>) tournamentRepository.findAll();
        if (tournaments.isEmpty()) {
            throw new TournamentNotAcceptedException();
        }
        return tournaments;
    }

    // Get Certain Record
    @GetMapping("tournament/{Id}")
    public Tournament getTournamentById(@PathVariable String Id) {
        return tournamentRepository.findById(Long.parseLong(Id))
                .orElseThrow(() -> new TournamentNotFoundException(Long.parseLong(Id)));
    }

    // Create Record
    @PostMapping("/tournament")
    public Tournament createTournament(@RequestBody Map<String, String> tournament, HttpServletResponse res) {
        // Init Variables
        Date startDateParsed = null; Date endDateParsed = null;
        double entryFeeParsed = 0; double cashPrizeParsed = 0;

        String name = tournament.get("name");
        String startDate = tournament.get("start_date");
        String endDate = tournament.get("end_date");
        String location = tournament.get("location");
        String entryFee = tournament.get("entry_fee");
        String cashPrize = tournament.get("cash_prize");
        if (Objects.equals(name, "") || Objects.equals(startDate, "")
                || Objects.equals(endDate, "") || Objects.equals(location, ""))
        {
            throw new TournamentNotAcceptedException();
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMMM dd, yyyy");
        try {
            startDateParsed = dateFormat.parse(startDate);
            endDateParsed = dateFormat.parse(endDate);
            entryFeeParsed = Double.parseDouble(entryFee);
            cashPrizeParsed = Double.parseDouble(cashPrize);
        } catch (ParseException e) {
            res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            System.err.println(e.getMessage());
        }
        return tournamentRepository.save(new Tournament(name, startDateParsed,
                endDateParsed, location, entryFeeParsed, cashPrizeParsed));
    }

    // Replace Record
    @PutMapping("/tournament/{Id}")
    public Tournament editTournament(@PathVariable String Id,
                                     @RequestBody Map<String, String> tournament, HttpServletResponse res)
    {
        Tournament updateTournament = tournamentRepository.findById(Long.parseLong(Id))
                .orElseThrow(() -> new TournamentNotFoundException());
        // Init Variables
        Date startDateParsed = null; Date endDateParsed = null;
        double entryFeeParsed = 0; double cashPrizeParsed = 0;

        String name = tournament.get("name");
        String startDate = tournament.get("start_date");
        String endDate = tournament.get("end_date");
        String location = tournament.get("location");
        String entryFee = tournament.get("entry_fee");
        String cashPrize = tournament.get("cash_prize");

        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMMM dd, yyyy");
        try {
            startDateParsed = dateFormat.parse(startDate);
            endDateParsed = dateFormat.parse(endDate);
            entryFeeParsed = Double.parseDouble(entryFee);
            cashPrizeParsed = Double.parseDouble(cashPrize);
        } catch (ParseException e) {
            res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            System.err.println(e.getMessage());
        }

        updateTournament.setName(name);
        updateTournament.setStartDate(dateFormat.format(startDateParsed));
        updateTournament.setEndDate(dateFormat.format(endDateParsed));
        updateTournament.setLocation(location);
        updateTournament.setEntryFee(entryFeeParsed);
        updateTournament.setCashPrize(cashPrizeParsed);

        return tournamentRepository.save(updateTournament);
    }

    // Delete Record
    @DeleteMapping("/tournament/{Id}")
    public void deleteTournament(@PathVariable String Id) {
        Tournament tournament = tournamentRepository.findById(Long.parseLong(Id))
                .orElseThrow(() -> new TournamentNotFoundException(Long.parseLong(Id)));
        tournamentRepository.delete(tournament);
    }
}
