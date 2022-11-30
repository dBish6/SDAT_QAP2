package com.keyin.qap2.tournament.respository;

import com.keyin.qap2.tournament.model.Tournament;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentRepository extends CrudRepository<Tournament, Long> {

}
