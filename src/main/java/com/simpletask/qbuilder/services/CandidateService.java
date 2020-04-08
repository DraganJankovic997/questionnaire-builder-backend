package com.simpletask.qbuilder.services;

import com.simpletask.qbuilder.DTO.CandidateDTO;
import com.simpletask.qbuilder.entities.Candidate;
import com.simpletask.qbuilder.enums.Status;

import java.util.List;

public interface CandidateService {

    CandidateDTO addCandidate(Candidate candidate);
    List<CandidateDTO> getCandidates();
    CandidateDTO setCandidateStatus(int id, Status status);
    Candidate getCandidateById(int id);
    CandidateDTO getCandidateDTOById(int id);
}
