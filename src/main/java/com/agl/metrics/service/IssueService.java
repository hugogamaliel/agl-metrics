/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agl.metrics.service;

import com.agl.metrics.repository.IssueRepository;
import com.agl.metrics.dto.IssueDTO;
import com.agl.metrics.entity.Issue;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

/**
 *
 * @author hugo.reyes
 */
@Service
public class IssueService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(IssueService.class);
    private static final String MESSAGE = "--- [ " + IssueService.class.getSimpleName() + "] ";
    
    @Autowired
    private IssueRepository issueRepository;
    
    public IssueDTO getIssue(String jiraCardNumber) {
        LOGGER.info("{} Getting issue by Jira Card number {}... ", MESSAGE, jiraCardNumber);
        Optional<Issue> issueOpt = issueRepository.findByJiraCardNumber(StringUtils.stripToEmpty(jiraCardNumber));
        if (issueOpt.isEmpty()) {
            throw new EntityNotFoundException("Issue reference number " + jiraCardNumber);
            
        }
        
        IssueDTO issue = new IssueDTO();
        
        Issue issueEntity = issueOpt.get();
        issue.setIdIssue(issueEntity.getIdIssue());
        issue.setIssueType(issueEntity.getIssueType());
        issue.setPerson(issueEntity.getPerson());
        issue.setProject(issueEntity.getProject());
        issue.setStatus(issueEntity.getStatus());
        issue.setPriority(issueEntity.getPriority());
        issue.setJiraCardNumber(issueEntity.getJiraCard());
        issue.setPoints(issueEntity.getPoints());
        issue.setIsBJ(issueEntity.getIsBJ());
        issue.setIsPull(issueEntity.getIsPull());
        issue.setIteration(issueEntity.getIteration());
        issue.setDescription(issueEntity.getDescription());
        
        return issue;
    }
    
    public List<Object[]> getIssueIterationReport(Long iterationNumber){
  
        LOGGER.info("{} Getting issue Iteration Report {}... ", MESSAGE,"");
        
        List<Object[]> issueIterationReport = issueRepository.getIssueIterationReport(iterationNumber);
        
        try {
            return issueIterationReport;
        } catch(DataAccessException e) {
            LOGGER.error("===== There was an error getting data =====");
            return new ArrayList<>();
        }

    }
}
