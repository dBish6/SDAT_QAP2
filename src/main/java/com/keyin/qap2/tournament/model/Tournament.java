package com.keyin.qap2.tournament.model;

import jakarta.persistence.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "tournament")
public class Tournament {
    // Instance Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tournament_id")
    private long Id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "start_date", nullable = false)
    private String startDate;
    @Column(name = "end_date", nullable = false)
    private String endDate;
    @Column(name = "location", nullable = false)
    private String location;
    @Column(name = "entry_fee", nullable = false)
    private double entryFee;
    @Column(name = "cash_prize", nullable = false)
    private double cashPrize;

    // Constructors
    public Tournament() {
        this.name = null; this.startDate = null; this.endDate = null; this.location = null;
        this.entryFee = 0.0; this.cashPrize = 0.0;
    }

    public Tournament(Tournament tournament) {
        this.name = tournament.name; this.startDate = tournament.startDate;
        this.endDate = tournament.endDate; this.location = tournament.location;
        this.entryFee = tournament.entryFee; this.cashPrize = tournament.cashPrize;
    }

    public Tournament(String name, Date startDate, Date endDate, String location, double entryFee, double cashPrize) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMMM dd, yyyy");
        String startDateFormatted = dateFormat.format(startDate);
        String endDateFormatted = dateFormat.format(endDate);

        this.name = name; this.startDate = startDateFormatted; this.endDate = endDateFormatted;
        this.location = location; this.entryFee = entryFee; this.cashPrize = cashPrize;
    }

    // Getters and Setters
    public long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getLocation() {
        return location;
    }

    public double getEntryFee() {
        return entryFee;
    }

    public double getCashPrize() {
        return cashPrize;
    }

    public void setId(long id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setEntryFee(double entryFee) {
        this.entryFee = entryFee;
    }

    public void setCashPrize(double cashPrize) {
        this.cashPrize = cashPrize;
    }

    public void setTourament(ArrayList<String> tournamentArr) {
        this.Id = Long.parseLong(tournamentArr.get(0));
        this.name = tournamentArr.get(1);
        this.startDate = tournamentArr.get(2);
        this.endDate = tournamentArr.get(3);
        this.location = tournamentArr.get(4);
        this.entryFee = Double.parseDouble(tournamentArr.get(5));
        this.cashPrize = Double.parseDouble(tournamentArr.get(6));
    }

    // Custom Methods
    @Override
    public String toString() {
        return "Tournament{" +
                "Id=" + this.Id +
                ", name='" + this.name + '\'' +
                ", startDate=" + this.startDate +
                ", endDate=" + this.endDate +
                ", location='" + this.location + '\'' +
                ", entryFee=" + this.entryFee +
                ", cashPrize=" + this.cashPrize +
                '}';
    }
}
