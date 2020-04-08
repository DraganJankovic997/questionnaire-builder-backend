package com.simpletask.qbuilder.repositories;

import com.simpletask.qbuilder.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate,Integer> {
    Candidate findCandidateByEmail(String email);
    List<Candidate> findAllByOrderByLastStatusUpdateDesc();
}
