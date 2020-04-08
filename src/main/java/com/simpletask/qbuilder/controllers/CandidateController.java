package com.simpletask.qbuilder.controllers;


import com.simpletask.qbuilder.DTO.CandidateDTO;
import com.simpletask.qbuilder.entities.Candidate;
import com.simpletask.qbuilder.services.CandidateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value ="Candidate operations", description = "Operations for managing candidates and their interview invitations")
@RestController()
public class CandidateController {

    private CandidateService candidateService;


    @Autowired
    public CandidateController(CandidateService candidateService) {
        this.candidateService=candidateService;
    }

    @ApiOperation(value = "Invite a new candidate")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved data"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PostMapping("candidates/invite")
    public ResponseEntity<CandidateDTO> addCandidate(@RequestBody Candidate candidate){
        return new ResponseEntity<>(candidateService.addCandidate(candidate), HttpStatus.OK);
    }

    @ApiOperation(value = "Get a list of candidates")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved data"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("candidates")
    public ResponseEntity<List<CandidateDTO>> getCandidates(){
        return new ResponseEntity<>(candidateService.getCandidates(),HttpStatus.OK);
    }

    @ApiOperation(value = "Get information about a specific candidate by his user ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved data"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("candidates/{id}")
    public ResponseEntity<CandidateDTO> getCandidateById(@PathVariable ("id") int id ) {
        return new ResponseEntity<CandidateDTO>(candidateService.getCandidateDTOById(id), HttpStatus.OK);
    }
}
