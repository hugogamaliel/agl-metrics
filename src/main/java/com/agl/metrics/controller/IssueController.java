/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agl.metrics.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agl.metrics.service.IssueService;
import com.agl.metrics.dto.IssueDTO;

/**
 *
 * @author hugo.reyes
 */
@RestController
@RequestMapping("/issue-overview")
public class IssueController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(IssueController.class);
    private static final String MESSAGE = "[ISSUE-OVERVIEW] - ";

    @Autowired
    private IssueService issueService;
    
    
    @Operation(summary = "Get Issue overview")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Retrieve Issue overview data",
                content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = IssueDTO.class))}),
        @ApiResponse(responseCode = "404", description = "Issue reference number not found.",
                content = @Content)})
    @GetMapping(value = "/{jiraCardNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getIssueByJiraCardNumber(@Parameter(description = "Jira Card number") 
    @PathVariable String jiraCardNumber) {
        LOGGER.info("{} Getting Issue {} ", MESSAGE, jiraCardNumber);
        
        try {
            IssueDTO issue = issueService.getIssue(jiraCardNumber);
            LOGGER.info("{} Worksheet {} obtained successfully", MESSAGE, jiraCardNumber);
            
            return ResponseEntity.status(HttpStatus.OK).body(issue);  
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (DataAccessException e) {
            LOGGER.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        } 
    
    }
    
    @Operation(summary = "Get report of Points by Team Member for a given iteration")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Retrieve list of Issues per Iteration",
                content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = IssueDTO.class))})})
    @GetMapping(value = "/iteration-report/{iterationNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getIssueIterationReport(@Parameter(description = "Iteration number") 
    @PathVariable Long iterationNumber)
    {
        List<Object[]> issueIterationReport = issueService.getIssueIterationReport(iterationNumber);
        
        try {
            return ResponseEntity.status(HttpStatus.OK).body(issueIterationReport);
        } catch (DataAccessException e) {
            LOGGER.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        
    }
    
}
