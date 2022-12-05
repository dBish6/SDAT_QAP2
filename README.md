# SDAT_QAP2
This is my second QAP (Quantitative Assessment Point) project in my Software Design, Architecture, Testing class from Semester 4 2022. 
Solfware Development, Keyin Collage

This project was made to practice creating a Java REST API with Spring Boot while also running from a Docker Container. This is my first API in Java:)

## Available Endpoints
- GET: `http://localhost:8080/api/tournaments` = All tournaments.
- GET: `http://localhost:8080/api/tournament/<Id>` = Single tournament.
- POST: `http://localhost:8080/api/tournament` = Create tournamnet.
- PUT: `http://localhost:8080/api/tournament/<Id>` = Replace single tournamnet.
- DELETE:`http://localhost:8080/api/tournament/<Id>` = Remove single tournamnet.

## Format for Dates
MMMMM dd, yyyy <br />
e.g: December 5, 2022
